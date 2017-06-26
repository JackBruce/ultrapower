package ultrasafe.service;

import ultrasafe.pojo.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/5/31.
 */
public interface SpringJDBCService {

    int deleteDept(Integer deptno);
    int insertDept(Dept dept);
    int insertDept2(Dept dept);
    List insertDept3(final Dept dept);

}
