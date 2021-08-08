package po;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Novels entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NOVELS", schema = "SCOTT")
public class Novels extends AbstractNovels implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Novels() {
	}

	/** minimal constructor */
	public Novels(BigDecimal id, Classification classification, String state,
			String num) {
		super(id, classification, state, num);
	}

	/** full constructor */
	public Novels(BigDecimal id, Classification classification,
			String novelname, String author, String state, String num,
			String sutou, String img, Set<Chapters> chapterses,
			Set<Bookshelf> bookshelfs) {
		super(id, classification, novelname, author, state, num, sutou, img,
				chapterses, bookshelfs);
	}

}
