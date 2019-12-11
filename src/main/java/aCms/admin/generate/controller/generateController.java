package aCms.admin.generate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/genarate")
public class generateController {

    //페이지 생성 페이지
    @RequestMapping("/list")
    public String generatepage(HttpSession session, Model model) {
        System.out.println("생성 페이지 클릭!!");
        return "generatepage";
    }

    //자유게시판 생성 페이지 이동
    @RequestMapping("/commonBoard")
    public String commonBoard(HttpSession session, Model model) {
        System.out.println("생성 페이지 클릭!!");
        return "commonBoard";
    }

    //QnA게시판 생성 페이지 이동
    @RequestMapping("/qnaBoard")
    public String qnaBoard(HttpSession session, Model model) {
        System.out.println("생성 페이지 클릭!!");
        return "QnABoard";
    }
}
