package ultrasafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Dept;
import ultrasafe.service.BatchUpdateService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2017/6/1.
 */
@Controller
@RequestMapping("/batchUpdate")
public class BatchUpdateController {

    @Autowired
    private BatchUpdateService batchUpdateService;

    @RequestMapping("/batch1")
    @ResponseBody
    public int[] batchUpdate1(){
        return batchUpdateService.batchUpdate1();
    }

    @RequestMapping("/batch2")
    @ResponseBody
    public int[] batchUpdate2(){

        List list = new ArrayList();
        Dept dept1 = new Dept(65,"defa","dfasf");
        Dept dept2 = new Dept(66,"fds","uyft");
        Dept dept3 = new Dept(67,"regt","yrtu");
        list.add(dept1);
        list.add(dept2);
        list.add(dept3);
        return batchUpdateService.batchUpdate2(list);
    }

    @RequestMapping("/batch3")
    @ResponseBody
    public int[] batchUpdate3(){
        List list = new ArrayList();
        Object[] obj1 = {58,"gasfd","dizhi"};
        Object[] obj2 = {59,"mingzi","meiguosheng"};
        list.add(obj1);
        list.add(obj2);
        int[] count = batchUpdateService.batchUpdate3(list);
        return count;
    }

    @RequestMapping("/batch4")
    @ResponseBody
    public int[][] batchUpdate4() {

        List list = new ArrayList();
        Dept dept1 = new Dept(55,"wo","shui");
        Dept dept2 = new Dept(56,"shi","shi");
        Dept dept3 = new Dept(57,"shui","wo");
        list.add(dept1);
        list.add(dept2);
        list.add(dept3);
        return batchUpdateService.batchUpdate4(list);
    }
}
