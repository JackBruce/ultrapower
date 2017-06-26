package ultrasafe.dao;

import ultrasafe.pojo.Dept;

/**
 * Created by root on 2017/6/1.
 */
public interface ExecuteDao {
    void execute();
    int preparedStatement();
    Integer preparedStatementCallBacker(String deptno);
    void testpreparedStatementCallbacker();
    void test();
}
