package aCms.admin.board.controller;

import aCms.admin.board.domain.BoardDto;
import aCms.admin.board.domain.BoardTestDto;
import aCms.admin.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiBoardTestController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/boardTest", method = RequestMethod.POST)
    public ResponseEntity boardTest(@RequestBody BoardTestDto dto) {
        System.out.println("dto.name : " + dto.getName());
        System.out.println("dto.description : " + dto.getDescription());
        System.out.println("dto.userYn : " + dto.getUseYn());
        System.out.println("dto.regUser : " + dto.getRegUser());
        System.out.println("date : " + dto.getDate());
        return new ResponseEntity(HttpStatus.OK);
    }

//    @ResponseBody
//    @RequestMapping(value = "/makeFile/{dirName}", method = RequestMethod.POST)
//    public ResponseEntity test(@PathVariable String dirName, @RequestBody BoardDto element) throws IOException {

//        final String root = "C:\\Users\\kimda\\Desktop\\workplace\\acms\\src\\main\\java\\aCms\\boards\\";
//
//        String packagePath = dirName;
//        String packageName = dirName.toUpperCase().charAt(0)+dirName.substring(1);
//        String controller = "Controller";
//        String java = ".java";
//        String controllerFileName = packageName+controller+java;
//        String service = "Service";
//        String serviceFileName = packageName+service+java;
//        String dao = "Dao";
//        String daoFileName = packageName+dao+java;
//        String domainFileName = packageName + java;
//
//        String controllerName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+controller;
//        String serviceName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+service;
//        String daoName = dirName.toUpperCase().charAt(0)+dirName.substring(1)+dao;
//
//        String dirStr = root+packagePath;
//
//        Mkdir(dirStr); //디렉토리 생성
//        Mkdir(dirStr+"\\"+"controller"); //컨트롤러 디렉토리 생성
//        Mkdir(dirStr+"\\"+"service"); //컨트롤러 디렉토리 생성
//        Mkdir(dirStr+"\\"+"dao"); //컨트롤러 디렉토리 생성
//        Mkdir(dirStr+"\\"+"domain");
//
//        String dirSt1 = root+packagePath+"\\controller\\"+controllerFileName;
//        String dirSt2 = root+packagePath+"\\service\\"+serviceFileName;
//        String dirSt3 = root+packagePath+"\\dao\\"+daoFileName;
//        String dirSt4 = root+packagePath+"\\domain\\"+domainFileName;
//
//        //
//        newFile(dirSt1);
//        newFile(dirSt2);
//        newFile(dirSt3);
//        newFile(dirSt4);
//
//        FileWriter writer = null;
//
//        String packagePath2 = "\"/" +packagePath+'"';
//
//        //controller, service, dao, domain 만드는 메소드들
//        controllerMaker(packagePath, controllerName, dirSt1, packagePath2);
//        serviceMaker(packagePath, serviceName, dirSt2);
//        daoMaker(packagePath, packageName, daoName, dirSt3);
//        domainMaker(packagePath, packageName, dirSt4);
//        System.out.println("완료오");
//
//        Map<String, String> map = new HashMap<>();
//        System.out.println("success !!!!");
//        System.out.println("css : " + element.getCss());
//        System.out.println("html : " + element.getHtml());
//
//        List<String> list = new ArrayList<>();
//        List<String> checkList = new ArrayList<>();
//        list.add("header");
//        list.add("leftcolumn");
//        list.add("rightcolumn");
//        list.add("content");
//        list.add("footer");
//
//        String[] array = element.getHtml().split("<div id=");
//        for (int i = 0; i < array.length; i++) {
//            array[i] = array[i].substring(2);
//            System.out.println("가자~ : " + array[i]);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                if (array[i].startsWith(list.get(j))) {
//                    checkList.add(array[i]);
//                    System.out.println(list.get(j));
//                };
//            };
//        }
//        newJspInfo(element, dirName);
////        newCss(element, dirName);
//        boardService.create(dirName);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @ResponseBody
    @RequestMapping(value = "/makeFile/{dirName}", method = RequestMethod.POST)
    public ResponseEntity test(@PathVariable String dirName, @RequestBody BoardDto element) throws IOException {
        Map<String, String> map = new HashMap<>();
        System.out.println("success !!!!");
        newJspInfo(element, dirName);
        System.out.println("html : " + element.getHtml());
        boardService.createTest(dirName);
        return new ResponseEntity(HttpStatus.OK);
    }




    private void domainMaker(String packagePath, String packageName, String dirSt4) throws IOException {
        FileWriter writer;
        String message4 = "package aCms.boards." + packagePath + ".domain;\n" +
                "public class "+ packageName + "{\n\n}";

        writer = new FileWriter(dirSt4, true);
        writer.write(message4);
        writer.flush();
    }

    private void daoMaker(String packagePath, String packageName, String daoName, String dirSt3) throws IOException {
        FileWriter writer;
        String message3 = "package aCms.boards."+packagePath+".dao;\n" +
                "import aCms.boards."+packagePath+".domain."+packageName+";\n" +
                "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                "\n" +
                "\n" +

                "public interface "+daoName+" extends JpaRepository<"+packageName+", Long> {\n" +
                "\n" +

                "\n" +
                "}";

        writer = new FileWriter(dirSt3, true);
        writer.write(message3);
        writer.flush();
    }

    private void serviceMaker(String packagePath, String serviceName, String dirSt2) throws IOException {
        FileWriter writer;
        String message2 = "package aCms.boards." + packagePath + ".service;\n\n" +
                "import org.springframework.http.ResponseEntity;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "@Service\n" +
                "public class "+ serviceName +" {\n" +
                "\n" +

                "\n" +
                "}";

        writer = new FileWriter(dirSt2, true);
        writer.write(message2);
        writer.flush();
    }

    private void controllerMaker(String packagePath, String controllerName, String dirSt1, String packagePath2) throws IOException {
        FileWriter writer;
        String message1 = "package aCms.boards."+packagePath+".controller;\n" +
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

        writer = new FileWriter(dirSt1, true);
        writer.write(message1);
        writer.flush();
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

    private void newJs() {}

    private void newCss(BoardDto element, String dirName) {
        final String location = "C:\\Users\\kimda\\Desktop\\workplace\\acms\\src\\main\\webapp\\resources\\css\\boards";

        String fileName ="";
        fileName = location + dirName + ".css";
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(element.getCss());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newJspInfo(BoardDto element, String dirName) {
        final String location = "C:\\Users\\kimda\\Desktop\\workplace\\acms\\src\\main\\webapp\\WEB-INF\\views\\cms\\boards\\";


        String fileName = "";
        fileName = location + dirName + ".html";
        File file = new File(fileName);
        String finish = makeString(element, dirName);
        System.out.println("finish : " + finish);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(finish);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeString(BoardDto element, String dirName) {
        String parseElement = boardService.parseJsp(element, dirName);

        String html = "";

        html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>" + dirName + "</title>\n" +
                "     <link href=\"http://localhost:8080//resources/css/board/board.css\" rel=\"stylesheet\">\n"+
                "  <script\n" +
                "  src=\"https://code.jquery.com/jquery-2.2.4.js\"\n" +
                "  integrity=\"sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=\"\n" +
                "  crossorigin=\"anonymous\"></script>" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                parseElement + "\n" +
                "<script src=\"http://localhost:8080//resources/js/board/makedBoard.js\"></script>" + "\n" +
                "\n</body>\n" +
                "</html>";
        return html;
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
