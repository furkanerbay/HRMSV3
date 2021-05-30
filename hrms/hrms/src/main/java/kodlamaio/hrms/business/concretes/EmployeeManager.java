package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.checkHelper.EmployeeCheckHelper;
@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao)
	{
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<> (this.employeeDao.findAll(),"Verileriniz getirildi - Employee");
	}

	
	
	/*
	@Override
	public Result register(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDao.save(employee);
		return new SuccessResult("Eklendi - Employee");
	}
	*/
	
	@Override
	public DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<>(EmployeeCheckHelper.isConfirmed(confirmedEmployerUser));
	}

	
	
	

	
	
	

}
