package ultrasafe.dao;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import ultrasafe.pojo.Emp;

import java.util.List;
import java.util.Map;

public class EmpDaoImpl extends NamedParameterJdbcDaoSupport implements EmpDao {


    @Override
    public List<Map<String, Object>> findEmp() {

        return this.getJdbcTemplate().queryForList("select * from emp");
    }

//    public Emp queryForObject(Emp emp) {
//        //方法有返回值
//        return (Emp) this.getJdbcTemplate().queryForObject("select * from emp where empno = ?",
//                new Object[]{emp.getEmpno()},
//                new int[]{java.sql.Types.INTEGER},
//                new RowMapper() {
//
//                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Emp emp = new Emp();
//                        emp.setEmpno(rs.getString("EMPNO"));
//                        emp.setEname(rs.getString("ENAME"));
//                        emp.setJob(rs.getString("JOB"));
//                        return emp;
//                    }
//                }
//        );
//    }


    @Override
    public List<Map<String,Object>> findEmpByName(Emp emp){

//        System.out.print(emp.getEname());
//        String SELECT_BY_NAME = "select * from emp where ename=:ename";
//        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
//
//        Map<String,Object> list = this.getNamedParameterJdbcTemplate().queryForObject(SELECT_BY_NAME,namedParameters,String.class);
        return null;
    }
}
