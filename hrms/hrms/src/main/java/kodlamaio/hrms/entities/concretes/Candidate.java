package kodlamaio.hrms.entities.concretes;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{
	@Column(name = "first_name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	

}
