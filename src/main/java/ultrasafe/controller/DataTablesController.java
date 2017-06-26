package ultrasafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ultrasafe.service.EmpService;

/**
 * Created by root on 2017/5/24.
 */
@Controller
public class DataTablesController {
	
	@Autowired
	private EmpService empService;
	
    @RequestMapping("/getJson")
    @ResponseBody
    public List<Map<String,Object>> getJson(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        
       // list = empService.queryEmp();
       Map<String,Object> user1 = new HashMap<>();
        user1.put("USERNAME","zhao");
        user1.put("PASSWORD","123");
        Map<String,Object> user2 = new HashMap<>();
        user2.put("USERNAME","qian");
        user2.put("PASSWORD","123");
        Map<String,Object> user3 = new HashMap<>();
        user3.put("USERNAME","sun");
        user3.put("PASSWORD","123");
        Map<String,Object> user4 = new HashMap<>();
        user4.put("USERNAME","li");
        user4.put("PASSWORD","123");
        Map<String,Object> user5 = new HashMap<>();
        user5.put("USERNAME","zhou");
        user5.put("PASSWORD","123");
        Map<String,Object> user6 = new HashMap<>();
        user6.put("USERNAME","wu");
        user6.put("PASSWORD","456");
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);
        list.add(user1);list.add(user2);list.add(user3);list.add(user4);list.add(user5);list.add(user6);

        return list;
    }
}
