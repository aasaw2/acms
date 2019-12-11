package aCms.admin.authority.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class AuthorityDto {

    @Getter
    @Setter
    @ToString
    public static class AuthorityList {
        @NotBlank
        private String id;
        @NotBlank
        private String authorityCode;
        @NotBlank
        private String name;
        @NotBlank
        private String authorityUrl;
    }

    @Getter
    @Setter
    @ToString
    public static class AuthorityWrite {
        @NotBlank
        private Long id;
        @NotBlank
        private String authorityCode;
        @NotBlank
        private String name;
        @NotBlank
        private String authorityUrl;
        @NotBlank
        private String create;
        @NotBlank
        private String read;
        @NotBlank
        private String update;
        @NotBlank
        private String delete;
    }

    @Getter
    @Setter
    @ToString
    public static class AuthorityUpdate {
        @NotBlank
        private String authorityCode;
        @NotBlank
        private String authorityName;
        @NotBlank
        private String authorityUrl;
    }

    @Getter
    @Setter
    @ToString
    public static class AuthorityView {
        @NotBlank
        private String id;
        @NotBlank
        private String authorityCode;
        @NotBlank
        private String authorityName;
        @NotBlank
        private String authorityUrl;
    }
}
