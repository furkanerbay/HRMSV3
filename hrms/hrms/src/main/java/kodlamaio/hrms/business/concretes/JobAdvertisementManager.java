package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementsDao jobAdvertisementsDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao)
	{
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAll(), "Verileriniz donduruldu - JobAdvertisement");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatusTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAllByStatusTrue(),"Aktif Veriler - JobAdvertisement");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAllByEmployer_IdAndStatusTrue(employerId),"Aktif ve Firmaya Gore");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAllByStatusTrueOrderByPublishDateAsc(),"Tarihe gore listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAllByStatusTrueOrderByPublishDateDesc(),"Tarihe gore listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		try
		{
		this.jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult("Is ilani eklendi.");
		}
		catch(Exception e)
		{
			return new ErrorResult("Hata ile karsilasildi. Is ilani eklenemez");
		}
	}

	@Override
	public Result findById(int jobAdvertisementId, boolean status) {
		try {
			JobAdvertisement jobAdvertisement;
			jobAdvertisement = this.jobAdvertisementsDao.findById(jobAdvertisementId).get();
			
			jobAdvertisement.setStatus(status);
			this.jobAdvertisementsDao.save(jobAdvertisement);
			
			return new SuccessResult("Islem basarili");
		}catch(Exception e)
		{
			return new ErrorResult("Islem Basarisiz");
		}
	}

	

	
	
	

}
