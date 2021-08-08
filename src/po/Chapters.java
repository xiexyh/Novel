package po;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Chapters entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHAPTERS", schema = "SCOTT")
public class Chapters extends AbstractChapters implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Chapters() {
	}

	/** minimal constructor */
	public Chapters(BigDecimal id) {
		super(id);
	}

	/** full constructor */
	public Chapters(BigDecimal id, Novels novels, String chaptername,
			String contents) {
		super(id, novels, chaptername, contents);
	}

}
