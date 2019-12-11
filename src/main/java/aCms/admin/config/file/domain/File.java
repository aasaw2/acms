/*
 * CreateDay : 18. 11. 8 오후 5:20
 * fileName : File.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.config.file.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class File {
    private String result;
    private String errorMessage;

    public static final long MAX_UPLOAD_SIZE = 5000000;
    //public static final long MAX_UPLOAD_SIZE = 50000000;
    public static final String RESULT_ERROR = "ERROR";
    public static final String RESULT_SUCCESS = "SUCCESS";

    private Long fileId;
    private String fileName;
    private String regDate;
    private String imageUrl;
    private String downLoadUrl;

    @JsonIgnore
    private String filePath;
    @JsonIgnore
    private String fileRealName;
    @JsonIgnore
    private String fileExt;
    @JsonIgnore
    private Long fileSize;
    @JsonIgnore
    private int fileWidth;
    @JsonIgnore
    private int fileHeight;
    @JsonIgnore
    private String fileTable;
    @JsonIgnore
    private String fileTableDiv;
    @JsonIgnore
    private String fileTableId;
    @JsonIgnore
    private String useYn;

}
