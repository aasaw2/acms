package aCms.user.board;

import aCms.admin.boardContents.BoardContentsDto;
import aCms.admin.boardContents.BoardContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/board")
public class ApiUserBoardController {

    private BoardContentsService boardContentsService;

    @Autowired
    public ApiUserBoardController(BoardContentsService boardContentsService) {
        this.boardContentsService = boardContentsService;
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.POST)
    public ResponseEntity contentCreate(@RequestBody BoardContentsDto.list boardContentsDto, @PathVariable long id) {
        boardContentsService.contentCreate(boardContentsDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/content/{id}", method = RequestMethod.PUT)
    public ResponseEntity contentUpdate(@RequestBody BoardContentsDto.list boardContentDto, @PathVariable long id) {
        System.out.println("content update working");
        boardContentsService.contentUpdate(boardContentDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
