package ultrasafe.dao;

import ultrasafe.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/6/1.
 */
public interface SpringJDBCQueryDao {

    List<Map<String,Object>> queryForList1();
    List<Integer> queryForList2();
    List<Map<String,Object>> queryForList3(Integer deptno,String dname);

    Map<String,Object> queryForMap(Integer deptno,String dname);

    Integer queryForObject();
    Dept queryForObject2(String deptno);



    List<Dept> query1(Integer deptno1,Integer deptno2);
    List<Dept> query2();
    List<Dept> query3();
    Dept query4();
    List<Dept> query5();
    Dept query6(int deptno);


    Dept find(Integer deptno);
    List<Dept> find2(Integer deptno);
    List<Dept> find3(Integer deptno);
    Dept find4(Integer deptno);


}
