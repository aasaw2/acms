package aCms.admin.board.controller;

import aCms.admin.board.domain.BoardDto;
import aCms.admin.board.service.BoardService;
import aCms.admin.boardContents.BoardContentsDto;
import aCms.admin.boardContents.BoardContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/board")
public class ApiBoardController {

    private BoardService boardService;
    private BoardContentsService boardContentsService;

    @Autowired
    public ApiBoardController(BoardService boardService, BoardContentsService boardContentsService) {
        this.boardService = boardService;
        this.boardContentsService = boardContentsService;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody BoardDto.create boardDto) {
        System.out.println("board!!!!!");
        System.out.println("board : " + boardDto.getHtml() + " : " + boardDto.getName());
        boardService.create(boardDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody BoardDto.create boardDto, @PathVariable long id) {
        System.out.println("board update!!!");
        boardService.update(boardDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        System.out.println("board delete");
        boardService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/content", method = RequestMethod.POST)
    public ResponseEntity contentCreate(@RequestBody BoardContentsDto.list boardContentsDto, @PathVariable long id) {
        boardContentsService.contentCreate(boardContentsDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/content/{id}" , method = RequestMethod.PUT)
    public ResponseEntity contentUpdate(@RequestBody BoardContentsDto.list boardContentDto, @PathVariable long id) {
        boardContentsService.contentUpdate(boardContentDto, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/content/file", method = RequestMethod.POST)
    public ResponseEntity file(MultipartFile multipartFile) {
        System.out.println(multipartFile.getOriginalFilename());
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "/{id}/content/{contentId}", method = RequestMethod.PUT)
//    public ResponseEntity contentUpdate(@RequestBody BoardContentsDto.list boardContentDto, @PathVariable long id, @PathVariable long contentId) {
//        boardContentsService.contentUpdate(boardContentDto, id, contentId);
//        return null;
//    }

}
