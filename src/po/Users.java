package po;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USERS", schema = "SCOTT")
public class Users extends AbstractUsers implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(BigDecimal id, String username, String passwd) {
		super(id, username, passwd);
	}

	/** full constructor */
	public Users(BigDecimal id, Identify identify, String username,
			String passwd, String avatars) {
		super(id, identify, username, passwd, avatars);
	}

}
