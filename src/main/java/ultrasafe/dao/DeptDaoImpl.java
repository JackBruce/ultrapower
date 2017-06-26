package ultrasafe.dao;


import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;
import ultrasafe.pojo.Dept;


import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/5/21.
 */
public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao {

    /**
     * 查询表中的所有数据
     * @return
     */
    @Override
    public List<Dept> findALLDepts() {
        List<Dept> depts = new ArrayList<Dept>();
        String sql = "select * from Dept";
        List list = this.getJdbcTemplate().queryForList(sql);

        Iterator iterator = list.iterator();
        Dept dept = null;
        while (iterator.hasNext()) {
            Map deptMap = (Map) iterator.next();
            dept = new Dept();
            dept.setDeptno(((BigDecimal) deptMap.get("DEPTNO")).intValue());
            dept.setDname((String) deptMap.get("DNAME"));
            dept.setLoc((String) deptMap.get("LOC"));
            depts.add(dept);
        }
        return depts;
    }

    /**
     * 根据ID删除表中的一条数据
     * @param deptno
     * @return
     */
    @Override
    public int delete(int deptno){
        String sql = "delete from dept where deptno =?";
        //return this.getJdbcTemplate().update(sql, new Object[]{deptno});
        return this.getJdbcTemplate().update(sql, deptno);
    }

    /**
     * 添加一条数据
     * @param dept
     * @return
     */
    @Override
    public int add(Dept dept){
        String sql = "insert into dept (deptno, dname, loc) values (?, ?, ?)";
        //update方法可以有三个参数update(执行sql,参数列表，参数类型)
        //这个例子中没有写参数类型，jdbc会自动匹配
        //int result=this.getJdbcTemplate().update(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
        //int result=this.getJdbcTemplate().update(sql,new Object[]{dept.getDeptno(),dept.getDname(),dept.getLoc()});
        int result=this.getJdbcTemplate().update(sql,new Object[]{dept.getDeptno(),dept.getDname(),dept.getLoc()});
        return result;
    }


    /**
     * 插入数据时为了避免sql注入，我们做如下的使用方式
     */
    //避免sql注入
    @Override
    public void save(final Dept dept) {
        Assert.isNull(dept, "user is not null");

        this.getJdbcTemplate().update("insert into dept(deptno,dname,loc) values(?,?,?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,dept.getDeptno());
                ps.setString(2,dept.getDname());
                ps.setString(3,dept.getLoc());
            }
        });

    }

    /**
     * 插入一条数据，并返回插入的主键
     * @param dept
     * @return
     *
     */
    //返回插入的主键
    @Override
    public List saveAndGetPrimaryKey(final Dept dept) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.getJdbcTemplate().update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                                    PreparedStatement ps = connection.prepareStatement("insert into dept(deptno,dname,loc) values(70,?,?)", new String[] {"deptno"});
                                    ps.setString(1,dept.getDname());
                                    ps.setString(2, dept.getLoc());
                                    return ps;
                                }
                            },
                keyHolder);

        return keyHolder.getKeyList();
    }

    /**
     * 修改一条记录
     * @param dept
     * @return
     */
    @Override
    public int update(Dept dept){

        String sql = "update dept set dname = ?, loc = ? where deptno = ?";
        return this.getJdbcTemplate().update(sql,dept.getDname(),dept.getLoc(),dept.getDeptno());
    }

    /**
     * 根据ID查询一条
     */
    @Override
    public Dept findById(Integer deptno){

        String sql = "select *from dept where deptno = ?";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        Dept dept = this.getJdbcTemplate().queryForObject(sql,rowMapper,deptno);

        return dept;
    }

    /**
     * 对上边的方法，可以做以下的简化处理
     * @param deptno
     * @return
     */
    @Override
    public Dept queryForObject(Integer deptno) {
        return (Dept)this.getJdbcTemplate().queryForObject("select * from dept where deptno = ?",
                new Object[]{deptno},
                Dept.class); //class是结果数据的java类型  实际上这里是做反射，将查询的结果和User进行对应复制
    }





    /**
     * 批量操作    适合于增、删、改操作
     * 以修改为例，有以下代码
     * @param depts
     * @return
     */
    @Override
    public int[] batchUpdate(final List depts) {

        int[] updateCounts = this.getJdbcTemplate().batchUpdate(
                "update dept set dname = ?, loc = ? where deptno = ?",
                new BatchPreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, ((Dept)depts.get(i)).getDname());
                        ps.setString(2, ((Dept)depts.get(i)).getLoc());
                        ps.setLong(3, ((Dept) depts.get(i)).getDeptno());
                    }

                    @Override
                    public int getBatchSize() {
                        return depts.size();
                    }
                }
        );

        return updateCounts;
    }

}
