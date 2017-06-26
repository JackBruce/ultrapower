package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.BatchUpdateDao;

import java.util.List;

/**
 * Created by root on 2017/6/1.
 */
@Service
public class BatchUpdateServiceImpl implements BatchUpdateService {

    @Autowired
    private BatchUpdateDao batchUpdateDao;

    @Override
    public int[] batchUpdate1() {
        return batchUpdateDao.batchUpdate1();
    }

    @Override
    public int[] batchUpdate2(List list){
        return batchUpdateDao.batchUpdate2(list);
    }

    @Override
    public int[] batchUpdate3(List list){
        return batchUpdateDao.batchUpdate3(list);
    }

    @Override
    public int[][] batchUpdate4(List list){
        return batchUpdateDao.batchUpdate4(list);
    }
}
