package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="job_titles")
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String jobTitle;
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "jobTitle")
	 @Column(name = "id")
	 private List<JobAdvertisement> jobAdvertisements;
	
	public JobTitle()
	{
		
	}

	public JobTitle(int id, String jobTitle) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
	}
	
	
	
	//Lombok direk get ve set islemlerini yapti.
	

}
