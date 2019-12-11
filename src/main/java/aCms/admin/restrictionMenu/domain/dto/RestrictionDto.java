package aCms.admin.restrictionMenu.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class RestrictionDto {

    @Getter
    @Setter
    @ToString
    public static class create {
        @NotBlank
        private String name;

        @NotBlank
        private String url;

        @NotBlank
        private String create;

        @NotBlank
        private String read;

        @NotBlank
        private String update;

        @NotBlank
        private String delete;
    }
}
