package aCms.user.board;

import aCms.admin.board.domain.Board;
import aCms.admin.board.service.BoardService;
import aCms.admin.boardContents.BoardContents;
import aCms.admin.boardContents.BoardContentsDto;
import aCms.admin.boardContents.BoardContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/user/board")
public class UserBoardController {

    private UserBoardService userBoardService;
    private BoardService boardService;
    private BoardContentsService boardContentsService;
    @Autowired
    public UserBoardController(BoardService boardService ,UserBoardService userBoardService, BoardContentsService boardContentsService) {
        this.boardService = boardService;
        this.userBoardService = userBoardService;
        this.boardContentsService = boardContentsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showBoard(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.ASC) Pageable pageable, @PathVariable long id, Model model) {
        boardService.answerContents(id);
        Board board = boardService.findBoard(id);
        Page<BoardContentsDto> boardContentsList = boardService.showBoardContents(pageable, id);
        model.addAttribute("board", board);
        model.addAttribute("resultList", boardContentsList);
        String parse = parseHtml(board);
        System.out.println("check parse html : " + parse);
        model.addAttribute("jsp", parse);
        return "userBoardTemplate";
    }

    @RequestMapping(value = "/content/{id}", method = GET)
    public String contentListWrite(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "userBoardListTemplateWrite";
    }

    @RequestMapping(value = "/content/update/{id}", method = GET)
    public String contentUpdate(@PathVariable long id, Model model) {
        BoardContents boardContents = boardContentsService.findContent(id);
        System.out.println("content : " + boardContents.getName());
        model.addAttribute("content", boardContents);
        return "userBoardListTemplateModify";
    }

    @RequestMapping(value = "/contents/detail/{id}",method = GET)
    public String contentDetail(@PathVariable long id, Model model) {
        BoardContents boardContent = boardContentsService.findContent(id);
        System.out.println("contents : " + boardContent.getId());
//        Board board = boardService.findBoardByContent(id);
//        model.addAttribute("board", board);
        model.addAttribute("content", boardContent);
        model.addAttribute("jsp", parseDetailHtml(boardContent));
        model.addAttribute("path", "user");
        return "userBoardContentDetailTemplate";
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
        System.out.println("detail jsp name : " + name);
        return name;
    }
}
