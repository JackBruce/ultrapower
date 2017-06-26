package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.DeptDao;
import ultrasafe.pojo.Dept;

import java.util.List;

/**
 * Created by root on 2017/5/21.
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
   public List<Dept> findAllDepts(){
        List<Dept> deptList = deptDao.findALLDepts();
        return deptList;
    }

    @Override
    public int delete(int deptno){
       int result = deptDao.delete(deptno);
       return result;
    }

    @Override
    public int insert(Dept dept){
        int result = deptDao.add(dept);
        return result;
    }

    @Override
    public void save(Dept dept){
        deptDao.save(dept);
    }

    @Override
    public int update(Dept dept){
        return deptDao.update(dept);
    }

    @Override
    public Dept findById(Integer deptno){
        return deptDao.queryForObject(deptno);
    }



    @Override
    public List saveAndGetPrimaryKey(Dept dept){
        return deptDao.saveAndGetPrimaryKey(dept);
    }

    @Override
    public int[] batchUpdate(final List depts){
        return deptDao.batchUpdate(depts);
    }
}
