package aCms.admin.system.menu.dao.Dto;

import aCms.admin.common.extend.BaseEntityDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

import javax.persistence.OrderBy;

public class MenuDetailDto extends BaseEntityDate {

    @Getter
    @Setter
    @ToString
    public static class Write{
        @NotBlank
        private String menuSubLink;
        @NotBlank
        private String menuSubName;
        @NotBlank
        private String menuSubZone;
        @NotNull
        private int menuSubSort;
        @NotNull
        private int menuSubGroup;
        @NotNull
        private int menuSubLevel;
        @NotNull
        private long menuId;
    }

    @Getter
    @Setter
    @ToString
    public static class Update {
        @NotBlank
        private String menuSubLink;
        @NotBlank
        private String menuSubName;
        @NotBlank
        private String menuSubZone;
        @NotNull
        private int menuSubSort;
        @NotNull
        private int menuSubGroup;
        @NotNull
        private int menuSubLevel;
        @NotNull
        private long menuId;
    }
}
