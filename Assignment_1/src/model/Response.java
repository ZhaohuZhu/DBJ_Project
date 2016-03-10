package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Response
 *
 */
@Entity
@Table(name="RESPONSE")
public class Response implements Serializable {

	@Embeddable
    public static class ResponseId implements Serializable {
        /**
		 * composite ResponseId class
		 */
		private static final long serialVersionUID = 1L;
		@Column(name = "quiz_id")
        private Long quizId;
        @Column(name = "user_id")
        private Long userId;
        @Column(name = "question_id")
        private Long questionId;
        
         
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
			result = prime * result + ((quizId == null) ? 0 : quizId.hashCode());
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ResponseId other = (ResponseId) obj;
			if (questionId == null) {
				if (other.questionId != null)
					return false;
			} else if (!questionId.equals(other.questionId))
				return false;
			if (quizId == null) {
				if (other.quizId != null)
					return false;
			} else if (!quizId.equals(other.quizId))
				return false;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}    
    }
	
	private static final long serialVersionUID = 1L;
	//composite ResponseId
	@EmbeddedId
	private ResponseId Response_Id;
	
	// user answer for each question
	@Column(length = 300)
	private String UserAnswer;
	
	@ManyToOne
	@JoinColumn(name="Quiz_Id",insertable = false, updatable = false)
	private Quiz quizFor;
	
	@ManyToOne
	@JoinColumn(name="User_Id",insertable = false, updatable = false)
	private User user;
	
	
	public Response() {
		super();
	}
   
}
