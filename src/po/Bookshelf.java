package po;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Bookshelf entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BOOKSHELF", schema = "SCOTT")
public class Bookshelf extends AbstractBookshelf implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bookshelf() {
	}

	/** minimal constructor */
	public Bookshelf(BigDecimal id, Novels novels, String novelname) {
		super(id, novels, novelname);
	}

	/** full constructor */
	public Bookshelf(BigDecimal id, Novels novels, String novelname,
			String author, String img, BigDecimal usersId) {
		super(id, novels, novelname, author, img, usersId);
	}

}
