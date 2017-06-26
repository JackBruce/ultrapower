package ultrasafe.service;

import ultrasafe.pojo.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	/**查询部门信息*/
	List<Map<String,Object>> queryEmp();
    List<Map<String,Object>> findEmpByName(Emp emp);
}