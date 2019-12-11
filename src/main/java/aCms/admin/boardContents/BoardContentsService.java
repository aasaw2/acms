package aCms.admin.boardContents;

import aCms.admin.board.dao.BoardDao;
import aCms.admin.board.domain.Board;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardContentsService {

    private BoardContentsDao boardContentsDao;
    private ModelMapper modelMapper;
    private BoardDao boardDao;

    @Autowired
    public BoardContentsService(BoardContentsDao boardContentsDao, BoardDao boardDao, ModelMapper modelMapper) {
        this.boardContentsDao = boardContentsDao;
        this.modelMapper = modelMapper;
        this.boardDao = boardDao;
    }

    public PageImpl<BoardContentsDto> showContentsByBoardId(long id, Pageable pageable) {
        List<BoardContentsDto> boardContentsList;
        Page<BoardContents> boardContentsPage = boardContentsDao.findByBoardId(id, pageable);
        boardContentsList = boardContentsPage.getContent().parallelStream()
                  .map(boardContents -> modelMapper.map(boardContents, BoardContentsDto.class))
                .collect(Collectors.toList());
        PageImpl<BoardContentsDto> result = new PageImpl<>(boardContentsList, pageable, boardContentsPage.getTotalElements());
        return result;
    }

    public void contentCreate(BoardContentsDto.list boardContentsDto, long id) {
        Board board = boardDao.findOne(id);
        BoardContents boardContents = new BoardContents(boardContentsDto, board);
        boardContentsDao.save(boardContents);
    }

    public void findContentsAnswer(long id) {
        List<BoardContents> contentAnswers = boardContentsDao.findByBoardId(id);
        contentAnswers.size();
    }

    public BoardContents findContent(long id) {
        BoardContents boardContents = boardContentsDao.findOne(id);
        return boardContents;
    }

    public void showContentsByBoardId(long id) {
        List<BoardContents> boardContentsList = boardContentsDao.findByBoardId(id);
        boardContentsDao.delete(boardContentsList);
    }

    public void contentUpdate(BoardContentsDto.list boardContentDto, long id) {
        BoardContents content = boardContentsDao.findOne(id);
        content.update(boardContentDto);
        boardContentsDao.save(content);
    }
}
