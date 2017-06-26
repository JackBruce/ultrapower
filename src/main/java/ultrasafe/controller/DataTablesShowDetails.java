package ultrasafe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by root on 2017/5/25.
 */
@Controller
public class DataTablesShowDetails {
    @RequestMapping("/showDetails")
    @ResponseBody
    public List<Map<String,Object>> showDetails(String language){
        System.out.println(language);
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("language","java");map1.put("url","http://fdsadfgsdgfs");map1.put("desc","java....");
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("language","c++");map2.put("url","http://fdsadfgsdgfs");map2.put("desc","java....");
//        Map<String,Object> map3 = new HashMap<>();
//        map3.put("language","C");map3.put("url","http://fdsadfgsdgfs");map3.put("desc","java....");
//        Map<String,Object> map4 = new HashMap<>();
//        map4.put("language","Python");map4.put("url","http://fdsadfgsdgfs");map4.put("desc","java....");
//        Map<String,Object> map5 = new HashMap<>();
//        map5.put("language","Ruby");map5.put("url","http://fdsadfgsdgfs");map5.put("desc","java....");
//        Map<String,Object> map6 = new HashMap<>();
//        map6.put("language","PHP");map6.put("url","http://fdsadfgsdgfs");map6.put("desc","java....");
//        Map<String,Object> map7 = new HashMap<>();
//        map7.put("language","hadoop");map7.put("url","http://fdsadfgsdgfs");map7.put("desc","java....");
//        Map<String,Object> map8 = new HashMap<>();
//        map8.put("language","javascript");map8.put("url","http://fdsadfgsdgfs");map8.put("desc","java....");
//        Map<String,Object> map9 = new HashMap<>();
//        map9.put("language","xml");map9.put("url","http://fdsadfgsdgfs");map9.put("desc","java....");
//        list.add(map1);list.add(map2);list.add(map3);list.add(map4);list.add(map5);list.add(map6);
        list.add(map1);//list.add(map8);list.add(map9);
        return list;
    }
}
