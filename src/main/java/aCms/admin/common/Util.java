package aCms.admin.common;

import java.util.HashMap;

public class Util {
    protected HashMap getResultMap(String result, String message){
        HashMap resultMap = new HashMap();
        resultMap.put("result",result);
        resultMap.put("message",message);
        return resultMap;
    }

}
