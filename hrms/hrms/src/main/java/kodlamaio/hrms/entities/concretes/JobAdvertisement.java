package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_advertisements")
public class JobAdvertisement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "job_of_number_position")
    private String jobOfNumberPosition;

    @Column(name = "end_of_job_date")
    private LocalDate endOfJobDate;

    @Column(name = "status")
    private boolean status;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "publish_date")
    private Date publishDate;
    
    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

}
