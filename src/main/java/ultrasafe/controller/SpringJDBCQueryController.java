package ultrasafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Dept;
import ultrasafe.service.SpringJDBCQueryService;

import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/6/1.
 */
@Controller
@RequestMapping("/springjdbcquery")
public class SpringJDBCQueryController {

    @Autowired
    private SpringJDBCQueryService jdbcQueryService;


    @RequestMapping("/queryForList1")
    @ResponseBody
    public List<Map<String,Object>> queryForList1(){
        return jdbcQueryService.queryForList1();
    }

    @RequestMapping("/queryForList2")
    @ResponseBody
    public List<Integer> queryForList2(){
        return jdbcQueryService.queryForList2();
    }

    @RequestMapping("/queryForList3/{deptno}/{dname}")
    @ResponseBody
    public List<Map<String,Object>> queryForList3(@PathVariable Integer deptno,@PathVariable String dname){
        return jdbcQueryService.queryForList3(deptno,dname);
    }

    @RequestMapping("/queryForMap/{deptno}/{dname}")
    @ResponseBody
    public  Map<String,Object> queryForMap(@PathVariable Integer deptno,@PathVariable String dname){
        return jdbcQueryService.queryForMap(deptno,dname);
    }

    @RequestMapping("/queryForObject")
    @ResponseBody
    public Integer queryForObject(){
        return jdbcQueryService.queryForObject();
    }

    @RequestMapping("/queryForObject2/{deptno}")
    @ResponseBody
    public Dept queryForObject2(@PathVariable String deptno){
        return jdbcQueryService.queryForObject2(deptno);
    }

    @RequestMapping("/query1/{deptno1}/{deptno2}")
    @ResponseBody
    public List<Dept> query1(@PathVariable Integer deptno1,@PathVariable Integer deptno2){
        return jdbcQueryService.query1(deptno1,deptno2);
    }
    @RequestMapping("/query2")
    @ResponseBody
    public List<Dept> query2(){
        return jdbcQueryService.query2();
    }

    @RequestMapping("/query3")
    @ResponseBody
    public List<Dept> query3(){
        return jdbcQueryService.query3();
    }

    @RequestMapping("/query4")
    @ResponseBody
    public  Dept query4(){
        return jdbcQueryService.query4();
    }

    @RequestMapping("/query5")
    @ResponseBody
   public  List<Dept> query5(){
       return jdbcQueryService.query5();
    }

    @RequestMapping("/query6/{deptno}")
    @ResponseBody
    public Dept query6(@PathVariable int deptno){
        return jdbcQueryService.query6(deptno);
    }

    @RequestMapping("/find/{deptno}")
    @ResponseBody
    public Dept find(@PathVariable Integer deptno){
        return jdbcQueryService.find(deptno);
    }

    @RequestMapping("/find2/{deptno}")
    @ResponseBody
    public List<Dept> find2(@PathVariable Integer deptno){
        return jdbcQueryService.find2(deptno);
    }

    @RequestMapping("/find3/{deptno}")
    @ResponseBody
    public  List<Dept> find3(@PathVariable Integer deptno){
        return jdbcQueryService.find3(deptno);
    }

    @RequestMapping("/find4/{deptno}")
    @ResponseBody
    public Dept find4(@PathVariable Integer deptno){
        return jdbcQueryService.find4(deptno);
    }



}
