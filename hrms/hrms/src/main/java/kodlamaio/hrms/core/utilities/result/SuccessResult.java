package kodlamaio.hrms.core.utilities.result;

public class SuccessResult extends Result{
	
	//Başarılı olma durumu.
	
	public SuccessResult()
	{
		super(true);
	}
	
	public SuccessResult(String message)
	{
		super(true,message);
	}
	
	

}
