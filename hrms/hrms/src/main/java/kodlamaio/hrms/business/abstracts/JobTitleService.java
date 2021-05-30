package kodlamaio.hrms.business.abstracts;
import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>> getAll();
	
//	List<JobTitle> getAll();
	
//	JobTitle add(JobTitle jobTitle);
	
	
	Result add(JobTitle jobTitle);
	
	//Optional<JobTitle> getOnee();

}
