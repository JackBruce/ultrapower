package ultrasafe.service;

import ultrasafe.pojo.Dept;

import java.util.List;

/**
 * Created by root on 2017/5/21.
 */
public interface DeptService {
    List<Dept> findAllDepts();
    int delete(int deptno);
    int insert(Dept dept);
    void save(Dept dept);
    int update(Dept dept);
    Dept findById(Integer deptno);
    List saveAndGetPrimaryKey(Dept dept);
    int[] batchUpdate(final List depts);
}
