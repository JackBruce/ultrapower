package ultrasafe.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ultrasafe.pojo.Dept;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by root on 2017/6/1.
 */
public class BatchUpdateDaoImpl extends JdbcDaoSupport implements BatchUpdateDao {


    @Override
    public int[] batchUpdate1(){

        String sql1 = "insert into dept(deptno,dname,loc) values(11,'xiaona','guangdong')";
        String sql2 = "update dept set dname='wanwan',loc='anan' where deptno = 90";
        return this.getJdbcTemplate().batchUpdate(sql1,sql2);
    }

    @Override
    public int[] batchUpdate2(List<Dept> list){

        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        int[] count = this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public int getBatchSize() {
                return list.size();
                //这个方法设定更新记录数，通常List里面存放的都是我们要更新的，所以返回list.size();
            }
            @Override
            public void setValues(PreparedStatement ps, int i)throws SQLException {
                Dept dept = list.get(i);
                ps.setInt(1,dept.getDeptno());
                ps.setString(2,dept.getDname());
                ps.setString(3,dept.getLoc());
            }
        });

        return count;
    }

    @Override
    public int[] batchUpdate3(List list){
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        //int[] count = this.getJdbcTemplate().batchUpdate(sql,list);
        int[] count = this.getJdbcTemplate().batchUpdate(sql,list,new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR});
        return count;
    }


    @Override
    public int[][] batchUpdate4(List<Dept> list){
        String sql = "update dept set dname=? , loc=? where deptno=?";
       return this.getJdbcTemplate().batchUpdate(sql, list, list.size(), new ParameterizedPreparedStatementSetter<Dept>() {
           @Override
           public void setValues(PreparedStatement ps, Dept dept) throws SQLException {
               ps.setString(1,dept.getDname());
               ps.setString(2,dept.getLoc());
               ps.setInt(3,dept.getDeptno());
           }
       });
    }


}
