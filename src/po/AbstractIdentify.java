package po;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractIdentify entity provides the base persistence definition of the
 * Identify entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractIdentify implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String identifyname;
	private Set<Users> userses = new HashSet<Users>(0);

	// Constructors

	/** default constructor */
	public AbstractIdentify() {
	}

	/** minimal constructor */
	public AbstractIdentify(BigDecimal id, String identifyname) {
		this.id = id;
		this.identifyname = identifyname;
	}

	/** full constructor */
	public AbstractIdentify(BigDecimal id, String identifyname,
			Set<Users> userses) {
		this.id = id;
		this.identifyname = identifyname;
		this.userses = userses;
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

	@Column(name = "IDENTIFYNAME", nullable = false, length = 30)
	public String getIdentifyname() {
		return this.identifyname;
	}

	public void setIdentifyname(String identifyname) {
		this.identifyname = identifyname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "identify")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}