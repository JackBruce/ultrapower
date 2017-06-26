package ultrasafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.pojo.Dept;
import ultrasafe.service.DeptService;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是查询表中的所有数据
 * Created by root on 2017/5/21.
 */
@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @RequestMapping("/findAllDepts")
    @ResponseBody
    public List<Dept> findAllDepts(){
        List<Dept> deptList = deptService.findAllDepts();
        return deptList;
    }

    /**
     * 删除一条数据
     */
    @RequestMapping("/delete/{deptno}")
    @ResponseBody
    public int delete(@PathVariable int deptno){
        int result = deptService.delete(deptno);
        return result;
    }


    /**
     * 添加一条数据
     */

    @RequestMapping("/insert/{deptno}/{dname}/{loc}")
    @ResponseBody
    public int insert(@PathVariable int deptno,@PathVariable String dname,@PathVariable String loc){
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        dept.setLoc(loc);
        int result = deptService.insert(dept);
        return  result;
    }

    /**
     * 插入一条记录，防止sql注入问题
     * @param deptno
     * @param dname
     * @param loc
     */
    @RequestMapping("/save/{deptno}/{dname}/{loc}")
    @ResponseBody
    public void save(@PathVariable int deptno,@PathVariable String dname,@PathVariable String loc){
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        dept.setLoc(loc);
        deptService.insert(dept);
    }

    /**
     *修改一条记录
     */
    @RequestMapping("/update/{deptno}/{dname}/{loc}")
    @ResponseBody
    public int update(@PathVariable int deptno,@PathVariable String dname,@PathVariable String loc){
        Dept dept = new Dept();
        dept.setDeptno(deptno);
        dept.setDname(dname);
        dept.setLoc(loc);
        return deptService.update(dept);
    }

    /**
     * 根据id查询出一条数据
     */
    @RequestMapping("/findById/{deptno}")
    @ResponseBody
    public Dept findById(@PathVariable int deptno){
        return deptService.findById(deptno);
    }


    @RequestMapping("/saveAndGet/{dname}/{loc}")
    @ResponseBody
    public List saveAndGetPrimaryKey(@PathVariable String dname,@PathVariable String loc){
        Dept dept = new Dept();
        dept.setDname(dname);
        dept.setLoc(loc);
        return deptService.saveAndGetPrimaryKey(dept);
    }

    @RequestMapping("/batchUpdate")
    @ResponseBody
    public int[] batchUpdate(){
        Dept dept1 = new Dept(90,"wangbatian","bainjing345");
        Dept dept2 = new Dept(80,"dahuilang","bainjing345");
        Dept dept3 = new Dept(70,"xiaohongmao","dongjing345");
        List dept = new ArrayList();
        dept.add(dept1);
        dept.add(dept2);
        dept.add(dept3);
        return deptService.batchUpdate(dept);
    }
}
