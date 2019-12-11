package aCms.admin.boardContents.contentsAnswer;

import lombok.Getter;
import lombok.Setter;

public class ContentAnswerDto {

    @Getter
    @Setter
    public static class create {
        private String name;
        private String comment;
        private String accountName;
    }
}
