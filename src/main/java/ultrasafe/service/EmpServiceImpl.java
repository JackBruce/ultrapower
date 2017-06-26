package ultrasafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultrasafe.dao.EmpDao;
import ultrasafe.pojo.Emp;

import java.util.List;
import java.util.Map;

@Service//利用注解完成IOC
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Map<String,Object>> queryEmp() {
		System.out.println("在Service中查询........");
		
		return empDao.findEmp();
	}

	@Override
    public List<Map<String,Object>> findEmpByName(Emp emp){

	    return empDao.findEmpByName(emp);
    }
}