package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	
	//Result register(Employee employee);
	
	DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser);

}
