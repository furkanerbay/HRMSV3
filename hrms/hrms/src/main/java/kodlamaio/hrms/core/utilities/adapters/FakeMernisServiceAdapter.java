package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisServiceAdapter implements UserCheckService{

	@Override
	public boolean isPersonReal(String identityNumber, String firstName, String lastName, int birtOfYear) {
		return true;
	}

}
