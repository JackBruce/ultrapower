package ultrasafe.dao;

import ultrasafe.pojo.Dept;

import java.util.List;

/**
 * Created by root on 2017/6/1.
 */
public interface BatchUpdateDao {

    int[] batchUpdate1();
    int[] batchUpdate2(List<Dept> list);
    int[] batchUpdate3(List list);
    int[][] batchUpdate4(List<Dept> list);
}
