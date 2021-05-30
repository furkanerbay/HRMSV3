package kodlamaio.hrms.core.utilities.result;

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data = data;
		 
		//Super base sınıfın constructorı.
		//This classın.
		
		// TODO Auto-generated constructor stub
	}
	
	public DataResult(T data,boolean success)
	{
		super(success);
		this.data = data;
	}
	
	//Datanın get'i.
	public T getData()
	{
		return this.data;
	}

	//Fazla  veri tipi ile calısabildiğmiz  noktada 
	//Generic calısırız.
	
	

}
