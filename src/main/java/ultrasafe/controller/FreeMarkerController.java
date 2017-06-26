package ultrasafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Address;
import ultrasafe.pojo.Emp;
import ultrasafe.pojo.User;

import java.util.*;


/**
 * Created by root on 2017/5/20.
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {


    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("username", "张三");
        model.addAttribute("date", new Date());
        model.addAttribute("html2", "bruce Lee");

        List list = new ArrayList();
        list.add(new Address("中国","北京"));
        list.add(new Address("中国","上海"));
        list.add(new Address("美国","纽约"));
        model.addAttribute("list", list);


        return "hello";

    }

    @RequestMapping("/world")
    public String helloworld(Model model) {

        model.addAttribute("username", "李四");

        return "world";

    }
    
}
