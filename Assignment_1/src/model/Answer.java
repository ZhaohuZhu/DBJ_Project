package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 */
@Entity
@Table(name="ANSWER")
public class Answer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// id of answer, auto generated value
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Answer_Id;
	
	// is the answer correct or not
	private boolean Correct_or_not;
	
	
	// actual answer
	@Column(length = 300)
	private String Text;
	
	// question belongs to
	@ManyToOne
	@JoinColumn(name="Question_Id")
	private Question question; 
	
	@Column(name = "Deleted", columnDefinition = "boolean default false", nullable = false)
	private Boolean Deleted = false;
	
	private String Deleted_By;
	
	public Answer() {
		super();
	}
   
}
