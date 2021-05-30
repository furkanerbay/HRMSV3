package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.checkHelper.EmployeeCheckHelper;
import kodlamaio.hrms.entities.concretes.checkHelper.EmployerCheckHelper;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailService emailService;
	
	public EmployerManager(EmployerDao employerDao,EmailService emailService)
	{
		this.employerDao = employerDao;
		this.emailService = emailService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<> (this.employerDao.findAll(),"Veriler getirildi - Employer");
	}

	@Override
	public Result register(Employer employer) {
		
		boolean checkFields = !EmployerCheckHelper.allFieldReq(employer);
        boolean isConfirm = !EmployeeCheckHelper.isConfirmed(employer);
        
        if(checkFields || isConfirm)
        {
        	return new ErrorResult("Hatali....");
        }
		
		this.employerDao.save(employer);
		return new SuccessResult(this.emailService.sendEmail(employer).getMessage());
	}

}
