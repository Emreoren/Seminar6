package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	
	@Column(name = "GId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Setter(value = AccessLevel.NONE)
	private long gId;
	
	@Column(name = "Grade value")
	@NotNull
	@Min(1)
	@Max(30)
	private int grValue;
	
	@ManyToOne
	@JoinColumn(name = "SId")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "CId")//this will create a new column as fk
	private Course course;


	public Grade(int inputGrValue, Student inputStudent, Course InputCourse)
	{
		
		setGrValue(inputGrValue);
		setStudent(inputStudent);
		setCourse(InputCourse);
	}
	
}
