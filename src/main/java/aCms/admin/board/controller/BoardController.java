package aCms.admin.board.controller;

import aCms.admin.board.domain.Board;
import aCms.admin.board.domain.BoardDto;
import aCms.admin.board.service.BoardService;
import aCms.admin.boardContents.BoardContents;
import aCms.admin.boardContents.BoardContentsDto;
import aCms.admin.boardContents.BoardContentsService;
import aCms.admin.boardContents.contentsAnswer.ContentAnswer;
import aCms.admin.boardContents.contentsAnswer.ContentAnswerService;
import aCms.admin.boardHtml.BoardHtmlService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/admin/board")
public class BoardController {

    private BoardService boardService;
    private BoardHtmlService boardHtmlService;
    private BoardContentsService boardContentsService;
    private ContentAnswerService contentAnswerService;

    @Autowired
    public BoardController(BoardService boardService, BoardHtmlService boardHtmlService, BoardContentsService boardContentsService, ContentAnswerService contentAnswerService) {
        this.boardService = boardService;
        this.boardHtmlService = boardHtmlService;
        this.boardContentsService = boardContentsService;
        this.contentAnswerService = contentAnswerService;
    }

    // 보드 컨트롤러
    @RequestMapping(value = "", method = GET)
    public String board() {
        System.out.println("whywhywhy");
        return "board";
    }

    @RequestMapping(value = "/create", method = GET)
    public String createPage(Model model) {
        model.addAttribute("htmlList", boardHtmlService.findHtmlList());
        return "boardDetail";
    }

    // 게시판 관리 리스트
    @RequestMapping(value = "/list", method = GET)
    public String list(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        System.out.println("working!");
        PageImpl<BoardDto> boardList = boardService.boardPageable(pageable);
        System.out.println("working!");
        model.addAttribute("resultList", boardList);
        return "boardList";
    }

    @RequestMapping(value = "/{id}", method = GET)
    public String showDetail(@PathVariable long id, Model model) {
        Board board = boardService.findBoard(id);
        model.addAttribute("board", board);
        model.addAttribute("htmlList", boardHtmlService.findHtmlList());
        return "boardDetail";
    }

    @RequestMapping(value = "/show/{id}", method = GET)
    public String showBoard(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable long id, Model model) {
        boardService.answerContents(id);
        Board board = boardService.findBoard(id);
        Page<BoardContentsDto> boardContentsList = boardService.showBoardContents(pageable, id);
        model.addAttribute("board", board);
        model.addAttribute("resultList", boardContentsList);
        String parse = parseHtml(board);
        System.out.println("check parse html : " + parse);
        model.addAttribute("jsp", parse);
        return "boardTemplate";
    }

    @RequestMapping(value = "/{id}/content", method = GET)
    public String contentListWrite(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "boardListTemplateWrite";
    }

    @RequestMapping(value = "/{id}/content/qna", method = GET)
    public String contentQnaWrite(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "boardQnaTemplateWrite";
    }

    @RequestMapping(value = "/contents/detail/{id}", method = GET)
    public String contentShow(@PathVariable long id, Model model) {
        BoardContents boardContent = boardContentsService.findContent(id);
        System.out.println("workikksndkndkn!!!!");
//        Board board = boardService.findBoardByContent(id);
//        model.addAttribute("board", board);
        model.addAttribute("content", boardContent);
        model.addAttribute("jsp", parseDetailHtml(boardContent));
        model.addAttribute("path", "admin");
        return "boardContentDetailTemplate";
    }

    @RequestMapping(value = "/contents/update/{id}", method = GET)
    public String updateContent(@PathVariable long id, Model model) {
        BoardContents boardContents = boardContentsService.findContent(id);
        System.out.println("content : " + boardContents.getName());
        model.addAttribute("content", boardContents);
        return "boardContentUpdate";
    }

    @RequestMapping(value = "/content/answer/update/{id}", method = GET)
    public String updateAnswer(@PathVariable long id, Model model) {
        ContentAnswer contentAnswer = contentAnswerService.findAnswer(id);
        System.out.println("comment : " + contentAnswer.getComment());
        System.out.println("testtesttest");
        model.addAttribute("answer", contentAnswer);
        return "boardContentAnswerUpdate";
    }


    private String parseHtml(Board board) {
        if (!board.getHtml().getFileName().contains(".jsp")) {
            System.out.println("add jsp!!");
            return board.getHtml().getFileName() + ".jsp";
        }
        return board.getHtml().getFileName();
    }

    private String parseDetailHtml(BoardContents boardContents) {
        Board board = boardService.findBoardByContent(boardContents.getId());
        String name = board.getHtml().getFileName() + "_detail.jsp";
        System.out.println("check parse detail name : " + name);
        return name;
    }

}
