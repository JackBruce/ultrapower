package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.ExecuteDao;

/**
 * Created by root on 2017/6/1.
 */
@Service
public class ExecuteServiceImpl implements ExecuteService {

    @Autowired
    private ExecuteDao executeDao;

    @Override
    public void execute(){

        executeDao.execute();
    }

    @Override
    public int preparedStatement(){
        return executeDao.preparedStatement();
    }

    @Override
    public Integer preparedStatementCallBacker(String deptno){
        return executeDao.preparedStatementCallBacker(deptno);
    }

    @Override
    public  void testpreparedStatementCallbacker(){
        executeDao.preparedStatement();
    }

    @Override
    public void test(){
        executeDao.test();
    }
}
