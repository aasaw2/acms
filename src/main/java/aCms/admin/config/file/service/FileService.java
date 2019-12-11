/*
 * CreateDay : 18. 11. 8 오후 5:22
 * fileName : FileService.java
 * CreateName : Eido
 * Create by Amazingpeoples.io
 */

package aCms.admin.config.file.service;

import aCms.admin.config.file.domain.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Value("c:\\dev\\upload")
    private String saveFilePath;

    @Value("/img/")
    private String imageServerUrl;

   /* @Autowired
    FileDao fileDao;*/

 /*   public List<File> selectFileLIst(File fileVo) {
    //    List<File> fileLIst = fileDao.findAll();
      *//*  fileLIst.forEach(file -> {
            setImageFileUrl(file);
        });
        return fileLIst;*//*
    }
*/
    private void setImageFileUrl(File file) {
        file.setImageUrl(imageServerUrl + "/" + file.getFileTable() + "/" + file.getFileTableId() + "/" + file.getFileTableDiv() + "/" + file.getFileRealName());
    }
}
