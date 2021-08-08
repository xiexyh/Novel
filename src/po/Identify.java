package po;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Identify entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IDENTIFY", schema = "SCOTT")
public class Identify extends AbstractIdentify implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Identify() {
	}

	/** minimal constructor */
	public Identify(BigDecimal id, String identifyname) {
		super(id, identifyname);
	}

	/** full constructor */
	public Identify(BigDecimal id, String identifyname, Set<Users> userses) {
		super(id, identifyname, userses);
	}

}
