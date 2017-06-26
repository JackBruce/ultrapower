package ultrasafe.dao;


import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ultrasafe.pojo.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by root on 2017/5/31.
 */
public class SpringJDBCDaoImpl extends JdbcDaoSupport implements SpringJDBCDao {


    /**
     * update(...)只带一个参数的时候的使用方法
     */
    public int createTable() {
        String sql = "create table test(id NUMBER PRIMARY KEY, name varchar2(100))";
        return this.getJdbcTemplate().update(sql);
    }

    /**
     * @param deptno
     * @return update（String sql,{...})这个方法是执行DML语句的方法。可以有多参数
     */
    @Override
    public int deleteDept(Integer deptno) {
        String sql = "delete from dept where deptno = ?";
        //return this.getJdbcTemplate().update(sql,new Object[]{deptno});
        return this.getJdbcTemplate().update(sql, deptno);
    }

    /**
     * @param dept
     * @return update(...)参数的完整版使用方式
     */
    @Override
    public int insertDept(Dept dept) {
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        return this.getJdbcTemplate().update(sql, new Object[]{dept.getDeptno(), dept.getDname(), dept.getLoc()},
            new int[]{Types.INTEGER, Types.VARCHAR, Types.VARCHAR});
    }

    /**
     * @param dept
     * @return update(...)方法，带有预编译语句设值回调的使用方法
     */
    @Override
    public int insertDept2(Dept dept) {
        String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
        int count = this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1, dept.getDeptno());
                ps.setString(2, dept.getDname());
                ps.setString(3, dept.getLoc());
            }
        });
        return count;
    }

    /**
     * @return 这个方法获取一个Connection链接。可以在里边传任何参数。并执行
     */
    @Override
    public int deleteDeptById() {

        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement("delete from dept where deptno = ?");
                ps.setInt(1,50);
                return ps;
            }
        });
        return 0;
    }


    /**
     * 插入一条数据，并返回插入的主键
     *
     * @param dept
     * @return
     * update(new PreparedStatementCreator(),keyHolder);
     */
    @Override
    public List insertDept3(final Dept dept) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int count = this.getJdbcTemplate().update(new PreparedStatementCreator() {
                      @Override
                      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                          PreparedStatement ps = connection.prepareStatement("insert into dept(deptno,dname,loc) values(?,?,?)", new String[]{"deptno"});
                          ps.setObject(1, dept.getDeptno());
                          ps.setString(2, dept.getDname());
                          ps.setString(3, dept.getLoc());
                          return ps;
                      }
                  },
                keyHolder);
        System.out.println(count);

        return keyHolder.getKeyList();
    }

   

}
