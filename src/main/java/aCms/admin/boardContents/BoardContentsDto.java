package aCms.admin.boardContents;

import aCms.admin.account.domain.Account;
import aCms.admin.board.domain.Board;
import aCms.admin.boardContents.contentsAnswer.ContentAnswer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardContentsDto {

    private long id;
    private String name;
    private String comment;
    private Board board;
    private List<ContentAnswer> answer;
    private Account writer;

    @Getter
    @Setter
    public static class list {

        private long id;
        private String name;
        private String comment;
        private Board board;
        private ContentAnswer answer;
    }

    @Getter
    @Setter
    public static class qna {
        private long id;
        private String name;
        private Board board;
        private ContentAnswer answer;
    }
}
