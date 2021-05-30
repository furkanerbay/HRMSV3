 package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService)
	{
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll()
	{
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallaktif")
	public DataResult<List<JobAdvertisement>> findAllByStatusTrue()
	{
		return this.jobAdvertisementService.findAllByStatusTrue();
	}
	
	
	@GetMapping("/getByEmpId")
	public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(int employerId)
	{
		return this.jobAdvertisementService.findAllByEmployer_IdAndActiveTrue(employerId);
	}
	
	@GetMapping("/tarihegoreartan")
	public DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateAsc()
	{
		return this.jobAdvertisementService.findAllByStatusTrueOrderByPublishDateAsc();
	}
			
	@GetMapping("/tarihegoreazalan")
	public DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateDesc()
	{
		return this.jobAdvertisementService.findAllByStatusTrueOrderByPublishDateDesc();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement)
	{
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@PutMapping("update")
    public Result update(@RequestParam int jobId, @RequestParam boolean status){
        return this.jobAdvertisementService.findById(jobId,status);
    }
}
