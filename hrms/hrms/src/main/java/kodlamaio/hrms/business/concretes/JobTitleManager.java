package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao)
	{
		super();
		this.jobTitleDao = jobTitleDao;
	}
/*
	@Override
	public List<JobTitle> getAll() {
		
		return this.jobTitleDao.findAll();
	}
*/
	
	
	/*
	@Override
	public Optional<JobTitle> getOnee() {
		return this.jobTitleDao.findById(2);
	}
	*/
@Override
public DataResult<List<JobTitle>> getAll() {
	return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Data listelendi.");
	
}
/*
@Override
public JobTitle add(JobTitle jobTitle) {
	
	return this.jobTitleDao.save(jobTitle);
}
*/


@Override
public Result add(JobTitle jobTitle) {
	/*
	 if(isExistJobTitle(jobTitle.getJobTitle()) == true)
     {
         return new ErrorResult("Tekrar Eden KayÄ±t ! ");
     }
     */
     this.jobTitleDao.save(jobTitle);
     return new SuccessResult("BaÅŸarÄ± ile Eklendi - JobTitle");
 }


/*
 public boolean isExistJobTitle(String  alan) {
    for (int i = 0; i < getAll().getData().size(); i++) {
        if (getAll().getData().get(i).getJobTitle() == alan){
            return false;
        }
    }
    return true;
}
*/



/*
@Override
public Jobtitle add(JobTitle jobTitle) {
	
	// TODO Auto-generated method stub
	this.jobTitleDao.save(jobTitle);
	return new SuccessResult("Ürün eklendi.");
	//EKLEME OPERASYONU ICIN ALTYAPIMIZ HAZIR.
	 * 
	 
	
	return jobTitleDao.save(jobTitle);
}*/
	
	
	
	

}
