package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.checkHelper.CandidateCheckHelper;
@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	
	public CandidateManager(CandidateDao candidateDao,UserCheckService userCheckService)
	{
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<>(this.candidateDao.findAll(),"Veriler getirildi. - Candidate") ;
	}
	/*
	@Override
	public Candidate register(Candidate candidate) {
		// TODO Auto-generated method stub
		return this.candidateDao.save(candidate);
	}
	*/


	@Override
	public Result register(Candidate candidate) {
		
		boolean isChecked = !this.isPersonReal(candidate.getIdentityNumber(), candidate.getName(), candidate.getLastName(), candidate.getBirthYear()).getData();
		
		boolean checkedFields = !CandidateCheckHelper.allFieldsAreReq(candidate);
		
		if(isChecked || checkedFields)
		{
			return new ErrorResult("Hata...");
		}	
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Eklendi - Candidate");
		
		
		
	}


	@Override
	public DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear) {
		return new DataResult<>(this.userCheckService.isPersonReal(nationalityId, firstName, lastName, birtOfYear),true);
	}
	
}
