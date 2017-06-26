package ultrasafe.dao;

import ultrasafe.pojo.Emp;

import java.util.List;
import java.util.Map;


public interface EmpDao {

	List<Map<String,Object>> findEmp();
	List<Map<String,Object>> findEmpByName(Emp emp);



}
