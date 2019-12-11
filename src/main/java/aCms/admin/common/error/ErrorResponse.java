/*
 * fileName       : ErrorResponse.java
 * fileCreateDate : 18. 10. 8 오후 2:14
 * regName        : Eido
 * Copyright (c) 2018
 */

package aCms.admin.common.error;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private String message;
    private String code;
    private List<FieldError> errors;

    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }

}
