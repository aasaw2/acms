package aCms.user.main;

import aCms.admin.board.domain.Board;
import aCms.admin.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserMainController {

    private BoardService boardService;

    @Autowired
    public UserMainController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(ModelAndView modelAndView, HttpSession session, Model model) {
        System.out.println("main page is dworking");
        List<Board> boardList = boardService.findUserBoards();
        model.addAttribute("header", boardList);
        session.setAttribute("header", boardList);
        return "mainPage";
    }


}
