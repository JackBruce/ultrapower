package ultrasafe.service;

import java.util.List;

/**
 * Created by root on 2017/6/1.
 */
public interface BatchUpdateService {

    int[] batchUpdate1();
    int[] batchUpdate2(List list);
    int[] batchUpdate3(List list);
    int[][] batchUpdate4(List list);
}
