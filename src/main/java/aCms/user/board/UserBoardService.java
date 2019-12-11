package aCms.user.board;

import aCms.admin.board.dao.BoardDao;
import aCms.admin.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBoardService {

    private BoardDao boardDao;

    @Autowired
    public UserBoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public Board findBoard(long id) {
        return boardDao.findOne(id);
    }
}
