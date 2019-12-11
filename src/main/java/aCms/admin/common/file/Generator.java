package aCms.admin.common.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(value = "/Generator")
@RestController
public class Generator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    @RequestMapping(value = "/a/{dirName}", method = GET)
    public static void GeneratorController(@PathVariable String dirName) throws IOException {
        System.out.println("제네제네");

        //final String root = "D:\\dev\\workspace\\aCms\\src\\main\\java\\aCms\\";
        final String root = "C:\\dev\\";
        //final String root = "C:\\dev\\workspace\\amazingpeoples\\si\\aCms\\src\\main\\java\\aCms\\";

        String packagePath = dirName;
        String packageName = dirName.toUpperCase().charAt(0)+dirName.substring(1);
        String controller = "Controller";
        String java = ".java";
        String controllerFileName = packageName+controller+java;
        String service = "Service";
        String serviceFileName = packageName+service+java;
        String dao = "Dao";
        String daoFileName = packageName+dao+java;

        String controllerName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+controller;
        String serviceName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+service;
        String daoName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+dao;


        String dirStr = root+packagePath;

        Mkdir(dirStr); //디렉토리 생성

        Mkdir(dirStr+"\\"+controller); //컨트롤러 디렉토리 생성
        Mkdir(dirStr+"\\"+service); //컨트롤러 디렉토리 생성
        Mkdir(dirStr+"\\"+dao); //컨트롤러 디렉토리 생성

        String dirSt1 = root+packagePath+"\\controller\\"+controllerFileName;
        String dirSt2 = root+packagePath+"\\service\\"+serviceFileName;
        String dirSt3 = root+packagePath+"\\dao\\"+daoFileName;

        newFile(dirSt1);
        newFile(dirSt2);
        newFile(dirSt3);

        FileWriter writer = null;

        String packagePath2 = "\"/" +packagePath+'"';

        String message1 = "package aCms."+packagePath+".Controller;\n" +
                "import aCms.admin.common.Util;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                "\n" +
                "\n" +
                "@RequestMapping("+packagePath2+")\n" +
                "@Controller\n"+
                "public class "+ controllerName +" extends Util {\n" +
                "\n" +

                "\n" +
                "}";

        writer = new FileWriter(dirSt3, true);
        writer.write(message1);
        writer.flush();

        String message3 = "package aCms."+packagePath+".Dao;\n" +
                "import aCms."+packagePath+".domain."+packageName+";\n" +
                "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                "\n" +
                "\n" +

                "public interface "+daoFileName+" extends JpaRepository<"+packageName+", Long> {\n" +
                "\n" +

                "\n" +
                "}";

        writer = new FileWriter(dirSt3, true);
        writer.write(message3);
        writer.flush();

        System.out.println("완료오");
    }

    private static void newFile(String myFile) {
        System.out.println("myFile:::::"+myFile);

        File createFile = new File(myFile);
        try {
            if(createFile.createNewFile()){    //파일이 생성되는 시점
                System.out.println("파일이 생성되었습니다.");
            }else {
                System.out.println("파일을 생성하지 못했습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("예외 처리");
            System.out.println("파일을 생성하는 과정에서 오류가 발생했습니다.");
        }
    }

    private static void Mkdir(String newDir) {

        File createDir = new File(newDir);

        if(createDir.mkdir()){   //만드려는 디렉토리가 하나일 경우
            System.out.println("디렉토리를 생성했습니다.");
        }else{
            System.out.println("디렉토리를 생성하지 못했습니다.");
        }
    }

}
