package kodlamaio.hrms.core.utilities.result;

public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success)
	{
		this.success = success;
	}
	
	public Result(boolean success,String message)
	{
		this(success);
		this.message = message;
	}
	
	//Her ikisininde getini geçtik.
	
	public boolean isSuccess()
	{
		return this.success;
	}
	
	public String getMessage()
	{
		return this.message;
	}
}
