package ultrasafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Dept;
import ultrasafe.service.SpringJDBCService;

import java.util.List;

/**
 * Created by root on 2017/5/31.
 */
@Controller
@RequestMapping("/springjdbc")
public class SpringJDBCController {

    @Autowired
    private SpringJDBCService springJDBCService;

    @RequestMapping("/deleteDept/{deptno}")
    @ResponseBody
    public int deleteDept(@PathVariable Integer deptno){

        return springJDBCService.deleteDept(deptno);
    }

    @RequestMapping("/insertDept/{deptno}/{dname}/{loc}")
    @ResponseBody
    public int insertDept(@PathVariable Integer deptno ,@PathVariable String dname,@PathVariable String loc){

        Dept dept=new Dept(deptno,dname,loc);
        return springJDBCService.insertDept(dept);
    }

    @RequestMapping("/insertDept2/{deptno}/{dname}/{loc}")
    @ResponseBody
    public int insertDept2(@PathVariable Integer deptno ,@PathVariable String dname,@PathVariable String loc){
        Dept dept=new Dept(deptno,dname,loc);
        return springJDBCService.insertDept2(dept);
    }

    @RequestMapping("/insertDept3/{deptno}/{dname}/{loc}")
    @ResponseBody
    public List insertDept3(@PathVariable Integer deptno ,@PathVariable String dname,@PathVariable String loc){
        Dept dept=new Dept(deptno,dname,loc);
        return springJDBCService.insertDept3(dept);
    }
}
