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
 * AbstractClassification entity provides the base persistence definition of the
 * Classification entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClassification implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String typename;
	private Set<Novels> novelses = new HashSet<Novels>(0);

	// Constructors

	/** default constructor */
	public AbstractClassification() {
	}

	/** minimal constructor */
	public AbstractClassification(BigDecimal id, String typename) {
		this.id = id;
		this.typename = typename;
	}

	/** full constructor */
	public AbstractClassification(BigDecimal id, String typename,
			Set<Novels> novelses) {
		this.id = id;
		this.typename = typename;
		this.novelses = novelses;
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

	@Column(name = "TYPENAME", nullable = false, length = 50)
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classification")
	public Set<Novels> getNovelses() {
		return this.novelses;
	}

	public void setNovelses(Set<Novels> novelses) {
		this.novelses = novelses;
	}

}