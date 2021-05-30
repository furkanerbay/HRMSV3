package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	//Candidate register(Candidate candidate);
	
	Result register(Candidate candidate);
	
    DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear);

}
