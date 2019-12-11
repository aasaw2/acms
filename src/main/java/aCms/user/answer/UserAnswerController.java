package aCms.user.answer;

import aCms.admin.boardContents.contentsAnswer.ContentAnswer;
import aCms.admin.boardContents.contentsAnswer.ContentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/board/content")
public class UserAnswerController {

    private ContentAnswerService answerService;

    @Autowired
    public UserAnswerController(ContentAnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/answer/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id, Model model) {
        ContentAnswer contentAnswer = answerService.findAnswer(id);
        System.out.println("comment : " + contentAnswer.getComment());
        System.out.println("testtesttest");
        model.addAttribute("answer", contentAnswer);
        return "userBoardContentAnswerUpdate";
    }
}
