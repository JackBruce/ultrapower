package ultrasafe.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.*;

/**
 * Created by root on 2017/6/1.
 */
public class ExecuteDaoImpl extends JdbcDaoSupport implements ExecuteDao {

    @Override
    public void execute(){
        this.getJdbcTemplate().execute("create table ddd(dd number,ss varchar2(30))");
    }

    /**
     * execute(new PreparedStatementCreator() , new PreparedStatementCallback<Integer>());
     * @return
     */
    @Override
    public int preparedStatement() {
        int count = this.getJdbcTemplate().execute(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                return conn.prepareStatement("select count(*) from dept");
            }}, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.execute();
                ResultSet rs = ps.getResultSet();
                rs.next();
                return rs.getInt(1);
            }});
        return count;
    }

    /**
     * execute(sql, new PreparedStatementCallback<Integer>());
     * @param deptno
     * @return
     */
    @Override
    public Integer preparedStatementCallBacker(String deptno){
        String sql = "select count(*) from dept where deptno < ?";
        return this.getJdbcTemplate().execute(sql, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1,deptno);
                ps.execute();
                ResultSet rs = ps.getResultSet();
                rs.next();
                return rs.getInt(1);
            }
        });
    }

    /**
     * execute(new StatementCallback<Integer>());
     */
    @Override
    public void testpreparedStatementCallbacker(){
        int count = this.getJdbcTemplate().execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                stmt.execute("select count(*) from dept");
                ResultSet rs = stmt.getResultSet();
                rs.next();
                return rs.getInt(1);
            }
        });
        System.out.print(count);
    }

    @Override
    public void test(){
        System.out.println(this.getJdbcTemplate().getMaxRows());
        System.out.println(this.getJdbcTemplate().getFetchSize());
        System.out.println(this.getJdbcTemplate().getQueryTimeout());
        System.out.println(this.getJdbcTemplate().isIgnoreWarnings());
        System.out.println(this.getJdbcTemplate().isSkipResultsProcessing());
        System.out.println(this.getJdbcTemplate().isSkipUndeclaredResults());
    }
}
