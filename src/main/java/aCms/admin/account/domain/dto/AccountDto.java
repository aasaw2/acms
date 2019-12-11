package aCms.admin.account.domain.dto;

import aCms.admin.authority.domain.Authority;
import aCms.admin.division.domain.Division;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class AccountDto {
    @Getter
    @Setter
    @ToString
    public static class AccountList {
        private Long id;
        private String email;
        private String accountName;
    }

    @Getter
    @Setter
    @ToString
    public static class AccountWrite {
        @NotBlank
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String accountName;
        @NotBlank
        private String authorityId;
        private String divisionId;
    }

    @Getter
    @Setter
    @ToString
    public static class AccountUpdate {
        @NonNull
        private Long id;
        @NotBlank
        private String email;
        @NotBlank
        @JsonIgnore
        private String password;
        @NotBlank
        private String accountName;
        @NotBlank
        private String authorityId;
        private String divisionId;
        private Division division;
        private Authority authority;

    }

    @Getter
    @Setter
    @ToString
    public static class AccountView{
        private Long id;
        private String email;
        private String accountName;
        private String cmd;
        private String authorityId;
        private String divisionId;
        private Division division;
        private Authority authority;
    }
}
