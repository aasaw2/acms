package aCms.admin.file;

import aCms.admin.boardHtml.BoardHtml;
import aCms.admin.boardHtml.BoardHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileHtmlService {

    private BoardHtmlService boardHtmlService;

    @Autowired
    public FileHtmlService(BoardHtmlService boardHtmlService) {
        this.boardHtmlService = boardHtmlService;
    }

    String filePath = "C:\\Users\\kimda\\Desktop\\workplace\\acms\\src\\main\\webapp\\WEB-INF\\views\\cms\\boardHtml\\template\\";
    public List<BoardHtml> file(List<MultipartFile> files) throws IOException {

        List<BoardHtml> boardHtmlList = new ArrayList<>();

        File file1 = new File(filePath);

        if (file1.exists() == false) {
            file1.mkdirs();
        }

        for (int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i).getOriginalFilename() + " : upload!!!");
            File file = new File( filePath + files.get(i).getOriginalFilename());
            files.get(i).transferTo(file);
            BoardHtml boardHtml = new BoardHtml(files.get(i).getOriginalFilename());
            BoardHtml boardHtmlDto = boardHtmlService.save(boardHtml);
            boardHtmlList.add(boardHtmlDto);
        }
        return boardHtmlList;
    }
}
