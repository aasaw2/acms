package aCms.admin.system.code.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class CodeDetailDto {

    @Getter
    @Setter
    @ToString
    public static class Create {
        public Create() {}
        @NotBlank
        private int id;
        @NotBlank
        private String codeDetailName;
        @NotBlank
        private int codeDetailUse;
        @NotBlank
        private String codeDetailOrder;
        @NotBlank
        private String codeId;
    }

    @Getter
    @Setter
    @ToString
    public class Update {
        public Update() {}
        @NotBlank
        private int id;
        @NotBlank
        private String codeDetailName;
        @NotBlank
        private int codeDetailUse;
        @NotBlank
        private String codeDetailOrder;
        @NotBlank
        private String codeId;
    }
}
