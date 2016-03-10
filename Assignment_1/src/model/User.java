package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long   User_Id;
	
	@Column(length = 30)
	private String First_Name;
	
	@Column(length = 30)
	private String Last_Name;
	
	// email will be used as login name
	@Column(length = 50, unique=true)
	private String Email;
	
	@Column(length = 10)
	private String Password;
	
	@Column(length = 10)
	private String Role;
	
	@OneToMany(mappedBy="user")
	private Collection<Response> UesrResponse;
	
	@Column(name = "Deleted", columnDefinition = "boolean default false", nullable = false)
	private Boolean Deleted = false;

	private String Deleted_By;
	
	public User() {
		super();
	}
   
}
