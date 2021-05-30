package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(User user) {
		
		return new SuccessResult("Mesajiniz basari ile gonderildi." + user.getEmail());
	}
	
	

}
