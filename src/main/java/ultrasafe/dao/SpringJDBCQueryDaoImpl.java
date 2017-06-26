package ultrasafe.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ultrasafe.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 2017/6/1.
 */
public class SpringJDBCQueryDaoImpl extends JdbcDaoSupport implements SpringJDBCQueryDao {



    /**************************这里是Query的方法***************************/

    /**
     * query(sql, new Object[]{deptno1,deptno2},new RowMapper<Dept>())
     * @param deptno1
     * @param deptno2
     * @return
     */
    @Override
    public List<Dept> query1(Integer deptno1,Integer deptno2){

        String sql = "select * from dept where deptno>? and deptno<?";
        List<Dept> objList = this.getJdbcTemplate().query(sql, new Object[]{deptno1,deptno2},
                new RowMapper<Dept>() {
                    @Override
                    public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Dept dept = new Dept();
                        dept.setDeptno(rs.getInt("DEPTNO"));
                        dept.setDname(rs.getString("DNAME"));
                        dept.setLoc(rs.getString("LOC"));
                        return dept;
                }

        });
        return objList;
    }

    /**
     * query(sql,new Object[]{deptno},new int[]{Types.INTEGER},new ResultSetExtractor());
     * @param deptno
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Dept query6(int deptno) {
        String sql = "select * from dept where deptno = ?";
        Dept obj =(Dept) getJdbcTemplate().query(sql,new Object[]{deptno},new int[]{Types.INTEGER},new ResultSetExtractor(){
            public Object extractData(ResultSet rs) throws SQLException,DataAccessException {
                if (rs.next()) {
                    Dept dept = new Dept();
                    dept.setDeptno(rs.getInt("DEPTNO"));
                    dept.setDname(rs.getString("DNAME"));
                    dept.setLoc(rs.getString("LOC"));
                    return dept;
                }
                return null;
            }
        });
        return obj;

    }


    /**
     * query(sql, new Object[]{deptno},new RowCallbackHandler())
     * @param deptno
     * @return
     */
    @Override
    public Dept find(Integer deptno){
        final Dept dept=new Dept();
        this.getJdbcTemplate().query("select * from dept where deptno=?", new Object[]{deptno},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        dept.setDeptno(rs.getInt("DEPTNO"));
                        dept.setDname(rs.getString("DNAME"));
                        dept.setLoc(rs.getString("LOC"));
                    }
                });
        return dept;
    }


    /**
     *query(String sql, PreparedStatementSetter pss, RowMapper<T> rowMapper)
     * @param deptno
     * @return
     */
    @Override
    public List<Dept> find2(Integer deptno){
        String sql = "select * from dept where deptno<?";
        List<Dept> objList = this.getJdbcTemplate().query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1, deptno);
            }
        }, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                return dept;
            }
        });
        return objList;
    }

    /**
     * query(String sql, PreparedStatementSetter pss, RowCallbackHandler rch)
     */
    @Override
    public List<Dept> find3(Integer deptno){
        String sql="select * from dept where deptno<?";
        List list = new ArrayList();
        this.getJdbcTemplate().query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1, deptno);
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                list.add(dept);
            }
        });
        return list;
    }

    /**
     * query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse)
     */

    @Override
    public Dept find4(Integer deptno){
        String sql = "select * from dept where deptno = ?";

        Dept obj = (Dept)this.getJdbcTemplate().query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1,deptno);
            }
        }, new ResultSetExtractor<Dept>() {
            @Override
            public Dept extractData(ResultSet rs) throws SQLException, DataAccessException {
                List list = new ArrayList();
                if (rs.next()) {
                    Dept dept = new Dept();
                    dept.setDeptno(rs.getInt("DEPTNO"));
                    dept.setDname(rs.getString("DNAME"));
                    dept.setLoc(rs.getString("LOC"));

                    return dept;

                }
                return null;
            }
        });
        return obj;
    }

    /**
     * query(PreparedStatementCreator psc, RowMapper<T> rowMapper)
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> query2() {

        List list = new ArrayList();

        list = this.getJdbcTemplate().query(new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                String sql = "select * from dept where deptno<?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, 40);
                return ps;
            }
        }, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
               // System.out.println(rowNum);
               // System.out.println(rs);
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                return dept;
            }
        });

        return list;
    }

    /**
     *
     * query(PreparedStatementCreator psc, RowCallbackHandler rch)
     *
     */

    @SuppressWarnings("unchecked")
    public List<Dept> query3() {

        List list = new ArrayList();

        this.getJdbcTemplate().query(new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "select * from dept where deptno<?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, 40);
                return ps;
            }
        }, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                list.add(dept);
            }
        });

        //System.out.println(list.size());
        return list;
    }

    /**
     * query(PreparedStatementCreator psc, ResultSetExtractor<T> rse)
     *
     */
    @Override
    public Dept query4() {
        Dept dept = new Dept();
        dept = this.getJdbcTemplate().query(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "select * from dept where deptno=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, 20);
                return ps;
            }
        }, new ResultSetExtractor<Dept>() {
            @Override
            public Dept extractData(ResultSet rs) throws SQLException, DataAccessException {
                Dept dept1 = new Dept();
                if(rs.next()) {
                    dept1.setDeptno(rs.getInt("DEPTNO"));
                    dept1.setDname(rs.getString("DNAME"));
                    dept1.setLoc(rs.getString("LOC"));
                    return dept1;
                }
                return null;
            }
        });
        return dept;
    }

    /**
     * query( PreparedStatementCreator psc, final PreparedStatementSetter pss, final ResultSetExtractor<T> rse)
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Dept> query5() {

        List<Dept> deptlist = (List<Dept>)this.getJdbcTemplate().query(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql = "select * from dept where deptno<?";
                return con.prepareStatement(sql);
            }
        }, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, 80);
            }
        }, new ResultSetExtractor() {
            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Dept> list = new ArrayList<Dept>();
                while (rs.next()) {
                    Dept dept = new Dept();
                    dept.setDeptno(rs.getInt("DEPTNO"));
                    dept.setDname(rs.getString("DNAME"));
                    dept.setLoc(rs.getString("LOC"));
                    list.add(dept);
                }
                return list;
            }
        });
        return deptlist;
    }

    /**************************这里是queryForList的方法*************************/
    /**
     * queryForList(String sql)只传一个参数为sql语句，默认返回类型为List<Map>
     * @return
     */
    @Override
    public List<Map<String,Object>> queryForList1(){

        String sql = "select * from dept";
        return this.getJdbcTemplate().queryForList(sql);
    }

    /**
     * queryForList(String sql,Class<T> type)传入两个参数的情况，是指定返回数据的类型
     */
    @Override
    public List<Integer> queryForList2(){

//        String sql = "select count(*) from dept";
//
//        return this.getJdbcTemplate().queryForList(sql,Integer.class);

        String sql = "select count(*) from dept where deptno>? and deptno<?";
        return this.getJdbcTemplate().queryForList(sql,Integer.class,40,100);
    }



    /**
     * queryForList(String sql,...)通过不定长参数进行对sql的参数设置，同时，我们也可以指定参数的类型
     * @param deptno
     * @param dname
     * @return
     */
    @Override
    public List<Map<String,Object>> queryForList3(Integer deptno,String dname){

        String sql = "select * from dept where deptno = ? and dname = ?";
        //return this.getJdbcTemplate().queryForList(sql,deptno,dname);
        return this.getJdbcTemplate().queryForList(sql,new Object[]{deptno,dname},new int[]{Types.INTEGER,Types.VARCHAR});

    }






    /*****************************这里是queryForMap的方法*****************************/

    /**
     * 如果查询不到的话，会报错.所以我们需要捕获异常，并返回null
     * @param deptno
     * @param dname
     * @return
     */
    @Override
    public Map<String,Object> queryForMap(Integer deptno,String dname){

        try{
            //return this.getJdbcTemplate().queryForMap("select * from dept where deptno = 40");
            //return this.getJdbcTemplate().queryForMap("select * from dept where deptno = ? and dname = ?",deptno,dname);
            return this.getJdbcTemplate().queryForMap("select * from dept where deptno = ? and dname = ?",
                    new Object[]{deptno,dname},
                    new int[]{Types.INTEGER,Types.VARCHAR});
        }catch (Exception e){
            return null;
        }


    }

    /******************************这里是queryForObject的方法*****************************/

    @Override
    public Integer queryForObject(){
//        String sql = "select count(*) from dept";
//        return this.getJdbcTemplate().queryForObject(sql,Integer.class);


        String sql = "select count(*) from dept where deptno >? and deptno<?";
        //return this.getJdbcTemplate().queryForObject(sql,new Object[]{30,90},Integer.class);
        return this.getJdbcTemplate().queryForObject(sql,new Object[]{30,90},new int[]{Types.INTEGER,Types.INTEGER},Integer.class);
    }


    /**
     * 测试使用queryForObject中带有回调函数的使用方法
     */

    @Override
    public Dept queryForObject2(String deptno){
        String sql = "select * from dept where deptno = ?";
        return this.getJdbcTemplate().queryForObject(sql,new Object[]{deptno},new int[]{Types.INTEGER},new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("DEPTNO"));
                dept.setDname(rs.getString("DNAME"));
                dept.setLoc(rs.getString("LOC"));
                return dept;
            }
        });
    }

}
