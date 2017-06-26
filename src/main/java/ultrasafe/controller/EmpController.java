package ultrasafe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Emp;
import ultrasafe.service.EmpService;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/emp")
public class EmpController {

    //声明所依赖的Service对象并创建set,get方法
    //@Resource(name="empService")//指明EmpService接口注入的对象
    @Autowired
    private EmpService empService;

    @RequestMapping("/queryEmp")
    @ResponseBody
    public List<Map<String, Object>> queryDept(String mm , String ee/*Model model*/) {

        System.out.print(mm+ee);
        List<Map<String, Object>> empList = empService.queryEmp();

        return empList ;
    }

    @RequestMapping("/findEmpByName/{ename}")
    @ResponseBody
    public List<Map<String,Object>> findEmpByName(@PathVariable String ename){

        System.out.print(ename);
        Emp emp=new Emp();
        emp.setEname(ename);
        return empService.findEmpByName(emp);
    }
}