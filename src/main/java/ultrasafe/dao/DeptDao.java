package ultrasafe.dao;

import ultrasafe.pojo.Dept;

import java.util.List;

/**
 * Created by root on 2017/5/21.
 */
public interface DeptDao {
    List<Dept> findALLDepts();
    int delete(int deptno);
    int add(Dept dept);
    void save(final Dept dept);
    List saveAndGetPrimaryKey(final Dept dept);
    int update(Dept dept);
    Dept findById(Integer deptno);
    Dept queryForObject(Integer deptno);
    int[] batchUpdate(final List depts);
}
