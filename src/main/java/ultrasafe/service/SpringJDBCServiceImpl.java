package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.SpringJDBCDao;
import ultrasafe.pojo.Dept;

import java.util.List;

/**
 * Created by root on 2017/5/31.
 */
@Service
public class SpringJDBCServiceImpl implements SpringJDBCService {

    @Autowired
    private SpringJDBCDao jdbcDao;

    @Override
    public int deleteDept(Integer deptno){
        return jdbcDao.deleteDept(deptno);
    }

    @Override
    public int insertDept(Dept dept){
        return jdbcDao.insertDept(dept);
    }

    @Override
    public int insertDept2(Dept dept){
        return jdbcDao.insertDept2(dept);
    }

    @Override
    public List insertDept3(final Dept dept){
        return jdbcDao.insertDept3(dept);
    }

}
