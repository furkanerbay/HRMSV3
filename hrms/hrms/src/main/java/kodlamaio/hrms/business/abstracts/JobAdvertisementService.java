package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> findAllByStatusTrue();
	
	DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(int employerId);
	
	DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateAsc();
	
	DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateDesc();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result findById(int jobAdvertisementId,boolean status);
	

}
