package po;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractUsers entity provides the base persistence definition of the Users
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractUsers implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Identify identify;
	private String username;
	private String passwd;
	private String avatars;

	// Constructors

	/** default constructor */
	public AbstractUsers() {
	}

	/** minimal constructor */
	public AbstractUsers(BigDecimal id, String username, String passwd) {
		this.id = id;
		this.username = username;
		this.passwd = passwd;
	}

	/** full constructor */
	public AbstractUsers(BigDecimal id, Identify identify, String username,
			String passwd, String avatars) {
		this.id = id;
		this.identify = identify;
		this.username = username;
		this.passwd = passwd;
		this.avatars = avatars;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDENTIFY_ID")
	public Identify getIdentify() {
		return this.identify;
	}

	public void setIdentify(Identify identify) {
		this.identify = identify;
	}

	@Column(name = "USERNAME", nullable = false, length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWD", nullable = false, length = 30)
	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Column(name = "AVATARS")
	public String getAvatars() {
		return this.avatars;
	}

	public void setAvatars(String avatars) {
		this.avatars = avatars;
	}

}