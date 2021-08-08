package po;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractNovels entity provides the base persistence definition of the Novels
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractNovels implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Classification classification;
	private String novelname;
	private String author;
	private String state;
	private String num;
	private String sutou;
	private String img;
	private Set<Chapters> chapterses = new HashSet<Chapters>(0);
	private Set<Bookshelf> bookshelfs = new HashSet<Bookshelf>(0);

	// Constructors

	/** default constructor */
	public AbstractNovels() {
	}

	/** minimal constructor */
	public AbstractNovels(BigDecimal id, Classification classification,
			String state, String num) {
		this.id = id;
		this.classification = classification;
		this.state = state;
		this.num = num;
	}

	/** full constructor */
	public AbstractNovels(BigDecimal id, Classification classification,
			String novelname, String author, String state, String num,
			String sutou, String img, Set<Chapters> chapterses,
			Set<Bookshelf> bookshelfs) {
		this.id = id;
		this.classification = classification;
		this.novelname = novelname;
		this.author = author;
		this.state = state;
		this.num = num;
		this.sutou = sutou;
		this.img = img;
		this.chapterses = chapterses;
		this.bookshelfs = bookshelfs;
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
	@JoinColumn(name = "TYPE_ID", nullable = false)
	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@Column(name = "NOVELNAME", length = 2000)
	public String getNovelname() {
		return this.novelname;
	}

	public void setNovelname(String novelname) {
		this.novelname = novelname;
	}

	@Column(name = "AUTHOR", length = 500)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "STATE", nullable = false, length = 200)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "NUM", nullable = false, length = 200)
	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Column(name = "SUTOU")
	public String getSutou() {
		return this.sutou;
	}

	public void setSutou(String sutou) {
		this.sutou = sutou;
	}

	@Column(name = "IMG")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "novels")
	public Set<Chapters> getChapterses() {
		return this.chapterses;
	}

	public void setChapterses(Set<Chapters> chapterses) {
		this.chapterses = chapterses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "novels")
	public Set<Bookshelf> getBookshelfs() {
		return this.bookshelfs;
	}

	public void setBookshelfs(Set<Bookshelf> bookshelfs) {
		this.bookshelfs = bookshelfs;
	}

}