package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;



@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {

	@Column(name = "pId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Setter(value = AccessLevel.NONE)
	private long pId;
	
	
	@Column(name = "name")
	@NotNull
	@Pattern(regexp = "[A-Z{1}[a-z ]{3,15}")
	private String name;
	
	@Column(name = "surname")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,30}")
	private String surname;
	
	@Column(name = "degree")
	@NotNull
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")//need to point which column to point
	@ToString.Exclude
	private Course course;
	
	public Professor(String inputName, String inputSurname, Degree inputDegree)
	{
		setName(inputName);
		setSurname(inputSurname);
		setDegree(inputDegree);
	}
	
	
}
