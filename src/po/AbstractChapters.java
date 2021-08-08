package po;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractChapters entity provides the base persistence definition of the
 * Chapters entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractChapters implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Novels novels;
	private String chaptername;
	private String contents;

	// Constructors

	/** default constructor */
	public AbstractChapters() {
	}

	/** minimal constructor */
	public AbstractChapters(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractChapters(BigDecimal id, Novels novels, String chaptername,
			String contents) {
		this.id = id;
		this.novels = novels;
		this.chaptername = chaptername;
		this.contents = contents;
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
	@JoinColumn(name = "NOVEL_ID")
	public Novels getNovels() {
		return this.novels;
	}

	public void setNovels(Novels novels) {
		this.novels = novels;
	}

	@Column(name = "CHAPTERNAME", length = 500)
	public String getChaptername() {
		return this.chaptername;
	}

	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}

	@Column(name = "CONTENTS")
	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}