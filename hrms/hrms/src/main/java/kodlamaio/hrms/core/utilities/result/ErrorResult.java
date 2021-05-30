package kodlamaio.hrms.core.utilities.result;

public class ErrorResult extends Result{
	
	//Ekleme başarısız ise
	
	public ErrorResult()
	{
		super(false);
	}
	
	public ErrorResult(String message)
	{
		super(false,message);
	}

}
