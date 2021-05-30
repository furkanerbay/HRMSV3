package kodlamaio.hrms.entities.concretes.checkHelper;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateCheckHelper {
	
	public static boolean allFieldsAreReq(Candidate candidate){
        if (candidate.getEmail().strip().isEmpty()
                || candidate.getPassword().strip().isEmpty()
                || candidate.getName().strip().isEmpty()
                || candidate.getLastName().strip().isEmpty()
                || candidate.getIdentityNumber().strip().isEmpty()
                )
        {
            return false;
        }
        return true;
    }

}
