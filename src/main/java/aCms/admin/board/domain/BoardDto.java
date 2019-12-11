package aCms.admin.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private long id;
    private String name;
    private String css;
    private String html;
    private String js;

    @Getter
    @Setter
    public static class create {
        private String name;
        private long html;
    }
}
