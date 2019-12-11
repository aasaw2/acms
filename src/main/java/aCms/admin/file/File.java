package aCms.admin.file;

import org.springframework.web.multipart.MultipartFile;

public class File {

    private MultipartFile[] fileUpload;

    public MultipartFile[] getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(MultipartFile[] fileUpload) {
        this.fileUpload = fileUpload;
    }
}
