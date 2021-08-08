package po;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLASSIFICATION", schema = "SCOTT")
public class Classification extends AbstractClassification implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Classification() {
	}

	/** minimal constructor */
	public Classification(BigDecimal id, String typename) {
		super(id, typename);
	}

	/** full constructor */
	public Classification(BigDecimal id, String typename, Set<Novels> novelses) {
		super(id, typename, novelses);
	}

}
