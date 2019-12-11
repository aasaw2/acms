package aCms.admin.boardHtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardHtmlService {

    private BoardHtmlDao boardHtmlDao;

    @Autowired
    public BoardHtmlService(BoardHtmlDao boardHtmlDao) {
        this.boardHtmlDao = boardHtmlDao;
    }

    public List<BoardHtml> findHtmlList() {
        List<BoardHtml> boardHtmlList = boardHtmlDao.findAll();
        return boardHtmlList;
    }

    public BoardHtml findHtml(long id) {
        BoardHtml boardHtml = boardHtmlDao.findOne(id);
        return boardHtml;
    }

    public BoardHtml save(BoardHtml boardHtml) {
        return boardHtmlDao.save(boardHtml);
    }
}
