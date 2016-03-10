package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity
@Table(name="QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Question_Id;
	
	@Column(length = 10)
	private String Question_Type;
	
	// Question will be scored by the difficulty level{ difficult: 5, medium: 3, easy:1
	@Column(length = 10)
	private String Question_Diffculty;
	
	@Column(length = 300)
	private String Explantion;	
	
	@OneToMany(mappedBy="question")
	private Collection<Answer> Options = new ArrayList<Answer>(); 
	
	@ManyToOne
	@JoinColumn(name="Quiz_Id")
	private Quiz quiz;
	
	@Column(name = "Deleted", columnDefinition = "boolean default false", nullable = false)
	private Boolean Deleted = false;
	
	private String Deleted_By;
	
	public Question() {
		super();
	}
   
}
