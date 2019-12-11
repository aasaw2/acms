package aCms.user.answer;

import aCms.admin.boardContents.contentsAnswer.ContentAnswer;
import aCms.admin.boardContents.contentsAnswer.ContentAnswerDto;
import aCms.admin.boardContents.contentsAnswer.ContentAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/board/content")
public class ApiUserAnswerController {

    private ContentAnswerService contentAnswerService;

    @Autowired
    public ApiUserAnswerController(ContentAnswerService contentAnswerService) {
        this.contentAnswerService = contentAnswerService;
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ContentAnswerDto.create answerDto, @PathVariable long id) {
        // public ResponseEntity create(HttpServletRequest request, @PathVariable long id) {
        ContentAnswer answer = null;
        String ttt=null;
        try {
            //  ttt = request.getParameter("aaaaaaaa");
            answerDto = contentAnswerService.create(answerDto, id);
            System.out.println("name : " + answer.getComment());
        }catch (Exception e){
            e.getMessage();
            System.out.println(e.getStackTrace());
        }

        //  System.out.println(answer.toString());


        return new ResponseEntity(answerDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody ContentAnswerDto.create answerDto, @PathVariable long id) {
        contentAnswerService.update(answerDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
