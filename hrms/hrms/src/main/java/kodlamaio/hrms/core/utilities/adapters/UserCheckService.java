package kodlamaio.hrms.core.utilities.adapters;

public interface UserCheckService {
	
    boolean isPersonReal(String identityNumber,String firstName, String lastName, int birtOfYear);


}
