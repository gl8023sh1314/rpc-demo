package org.example.framework.register;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    //如果有版本号，在参数中添加一个version参数，把interfaceName和version拼接为key
    public static  void regist(String interfaceName, Class implClass ){
        map.put(interfaceName , implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
