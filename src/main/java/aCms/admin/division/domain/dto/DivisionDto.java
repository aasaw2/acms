/*
 * CreateDay : 18. 10. 18 오전 12:09
 * fileName : DivisionDto.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.division.domain.dto;

import aCms.admin.account.domain.Account;
import aCms.admin.authority.domain.Authority;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class DivisionDto {
    @Getter
    @Setter
    @ToString
    public static class divisionList {
        private Long id;
        private String divisionCode;
        private String divisionName;
    }

    @Getter
    @Setter
    @ToString
    public static class divisionWrite {
        private Long id;
        @NotBlank
        private String divisionCode;
        @NotBlank
        private String divisionName;
        @NotBlank
        private String authority;

    }

    @Getter
    @Setter
    @ToString
    public static class divisionView {
        private Long id;
        private String divisionCode;
        private String divisionName;
        private Authority authority;
        private Account account;
    }
}
