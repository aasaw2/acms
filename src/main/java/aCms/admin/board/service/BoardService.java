package aCms.admin.board.service;

import aCms.admin.account.domain.Account;
import aCms.admin.account.service.AccountSecService;
import aCms.admin.board.dao.BoardDao;
import aCms.admin.board.domain.Board;
import aCms.admin.board.domain.BoardDto;
import aCms.admin.boardContents.BoardContentsDto;
import aCms.admin.boardContents.BoardContentsService;
import aCms.admin.boardHtml.BoardHtml;
import aCms.admin.boardHtml.BoardHtmlService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private BoardDao boardDao;
    private AccountSecService accountSecService;
    private BoardHtmlService boardHtmlService;
    private ModelMapper modelMapper;
    private BoardContentsService boardContentsService;

    @Autowired
    public BoardService(BoardDao boardDao, AccountSecService accountSecService, ModelMapper modelMapper, BoardHtmlService boardHtmlService, BoardContentsService boardContentsService) {
        this.accountSecService = accountSecService;
        this.boardDao = boardDao;
        this.modelMapper = modelMapper;
        this.boardHtmlService = boardHtmlService;
        this.boardContentsService = boardContentsService;
    }

    public void createTest(String dirName) {
        Board board = new Board(dirName);
        boardDao.save(board);
        System.out.println("board id : " + board.getId());
    }

    public String parseJsp(BoardDto element, String dirName) {
        String parseJsp = element.getHtml().replace("게시판 만들기", dirName);
        return parseJsp;
    }

    public PageImpl<BoardDto> boardPageable(Pageable pageable) {
        List<BoardDto> boardList;
        Account account = accountSecService.findAccountByContextHolder();
        long id = account.getDivision().getId();
        Page<Board> boardPage = boardDao.findByDivisionId(pageable, id);
        boardList = boardPage.getContent().parallelStream()
                .map(board -> modelMapper.map(board, BoardDto.class))
                .collect(Collectors.toList());
        PageImpl<BoardDto> result = new PageImpl<>(boardList, pageable, boardPage.getTotalElements());
        return result;
    }

    public Page<Board> findAll(Pageable pageable) {
        Page<Board> boardList = boardDao.findAll(pageable);
        return boardList;
    }

    public Page<Board> pageable(Pageable pageable) {
        return null;
    }

    public Board findBoard(long id) {
        Board board = boardDao.findOne(id);
        System.out.println(board.getId());
        return board;
    }

    public void create(BoardDto.create boardDto) {
        Account account = accountSecService.findAccountByContextHolder();
        BoardHtml boardHtml = boardHtmlService.findHtml(boardDto.getHtml());
        Board board = new Board(boardDto, account, boardHtml);
        boardDao.save(board);
    }

    public Page<BoardContentsDto> showBoardContents(Pageable pageable, long id) {
        Page<BoardContentsDto> boardPage = boardContentsService.showContentsByBoardId(id, pageable);
        return boardPage;
    }

    public void answerContents(long id) {
        boardContentsService.findContentsAnswer(id);
    }

    public void update(BoardDto.create boardDto, long id) {
        Account account = accountSecService.findAccountByContextHolder();
        BoardHtml boardHtml = boardHtmlService.findHtml(boardDto.getHtml());
        Board board = findBoard(id);
        board.update(boardDto, account, boardHtml);
        boardDao.save(board);
    }

    public void delete(long id) {
        boardContentsService.showContentsByBoardId(id);
        boardDao.delete(id);
    }

    public Board findBoardByContent(long id) {
        Board board = boardDao.findByContentsId(id);
        return board;
    }

    // 사용자 부서
    public List<Board> findUserBoards() {
        return boardDao.findByDivisionId(90L);
    }
}
