package aCms.admin.boardContents.contentsAnswer;

import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

@RestController
@RequestMapping("/admin")
public class ApiContentAnswerController {

    private ContentAnswerService contentAnswerService;

    @Autowired
    public ApiContentAnswerController(ContentAnswerService contentAnswerService) {
        this.contentAnswerService = contentAnswerService;
    }

    @RequestMapping(value = "/board/content/answer/{id}", method = RequestMethod.POST)
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

    @RequestMapping(value = "/board/content/answer/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody ContentAnswerDto.create answerDto, @PathVariable long id) {
        contentAnswerService.update(answerDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
