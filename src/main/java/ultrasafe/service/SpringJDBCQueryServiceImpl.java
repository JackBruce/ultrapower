package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.SpringJDBCQueryDao;
import ultrasafe.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/6/1.
 */
@Service
public class SpringJDBCQueryServiceImpl implements SpringJDBCQueryService {

    @Autowired
    private SpringJDBCQueryDao jdbcQueryDao;

    @Override
    public List<Map<String,Object>> queryForList1(){

        return jdbcQueryDao.queryForList1();
    }
    @Override
    public List<Integer> queryForList2(){
        return jdbcQueryDao.queryForList2();
    }

    @Override
    public List<Map<String,Object>> queryForList3(Integer deptno,String dname){


        return jdbcQueryDao.queryForList3(deptno,dname);
    }

    @Override
    public Map<String,Object> queryForMap(Integer deptno,String dname){
        return jdbcQueryDao.queryForMap(deptno,dname);
    }

    @Override
    public Integer queryForObject(){

        return jdbcQueryDao.queryForObject();
    }

    @Override
    public Dept queryForObject2(String deptno){
        return jdbcQueryDao.queryForObject2(deptno);
    }

    @Override
    public List<Dept> query1(Integer deptno1,Integer deptno2){
        return jdbcQueryDao.query1(deptno1,deptno2);
    }

    @Override
    public List<Dept> query2(){
        return jdbcQueryDao.query2();
    }

    @Override
    public  List<Dept> query3(){
        return jdbcQueryDao.query3();
    }

    @Override
    public  Dept query4(){
        return jdbcQueryDao.query4();
    }

    @Override
    public List<Dept> query5(){
        return jdbcQueryDao.query5();
    }

    @Override
    public Dept query6(int deptno){
        return jdbcQueryDao.query6(deptno);
    }

    @Override
    public Dept find(Integer deptno){
        return jdbcQueryDao.find(deptno);
    }

    @Override
    public List<Dept> find2(Integer deptno){
        return jdbcQueryDao.find2(deptno);
    }

    @Override
    public  List<Dept> find3(Integer deptno){
        return jdbcQueryDao.find3(deptno);
    }

    @Override
    public Dept find4(Integer deptno){
        return jdbcQueryDao.find4(deptno);
    }
}
