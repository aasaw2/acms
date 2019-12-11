package aCms.admin.file;

import aCms.admin.boardHtml.BoardHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class FileController {

    private FileHtmlService fileService;

    @Autowired
    public FileController(FileHtmlService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity uploadFile(MultipartHttpServletRequest request) throws IOException {
        List<MultipartFile> files = request.getFiles("files");
        List<BoardHtml> boardHtmlList = fileService.file(files);
        return new ResponseEntity(boardHtmlList, HttpStatus.OK);
    }


}