package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quiz
 *
 */
@Entity
@Table(name="QUIZ")
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// quiz id, generated vale
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long   Quiz_Id;
	
	// name of the quiz
	@Column(length = 100)
	private String Quiz_Name;
	
	// due date of the quiz
	private Timestamp Deadline; 
	
	@OneToMany(mappedBy="quizFor")
	private Collection<Response> QuizResponse;
	
	// question list randomly selected for this quiz
	@OneToMany(mappedBy="quiz")
	private Collection<Question> QuestionList;
	
	@Column(name = "Deleted", columnDefinition = "boolean default false", nullable = false)
	private Boolean Deleted = false;
	
	private String Deleted_By;
	
	public Quiz() {
		super();
	}
}
