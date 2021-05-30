package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	private JobTitleService jobTitleService;
	
	
	@Autowired
	public JobTitlesController(JobTitleService jobTitleService)
	{
		this.jobTitleService = jobTitleService;
	}
	
	
	/*
	@GetMapping("/getall")
	
	public List<JobTitle> getAll()
	{
		return this.JobTitleService.getAll();
		//Burada donen bir datadir. İleride gelcek.	
	}
	*/
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll()
	{
		return this.jobTitleService.getAll();
	}
	

	/*
	@GetMapping("/getonee")
	
	public Optional<JobTitle> getOnee()
	{
		return this.JobTitleService.getOnee();
	}
	*/
	
	//Ürün eklenirken PostMapping
	@PostMapping("/add")
	/*
	public JobTitle add(@RequestBody JobTitle jobTitle)
	{
		return this.JobTitleService.add(jobTitle);
	}
	*/
	
	public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }
	
	
	

}
