package po;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractBookshelf entity provides the base persistence definition of the
 * Bookshelf entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractBookshelf implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Novels novels;
	private String novelname;
	private String author;
	private String img;
	private BigDecimal usersId;

	// Constructors

	/** default constructor */
	public AbstractBookshelf() {
	}

	/** minimal constructor */
	public AbstractBookshelf(BigDecimal id, Novels novels, String novelname) {
		this.id = id;
		this.novels = novels;
		this.novelname = novelname;
	}

	/** full constructor */
	public AbstractBookshelf(BigDecimal id, Novels novels, String novelname,
			String author, String img, BigDecimal usersId) {
		this.id = id;
		this.novels = novels;
		this.novelname = novelname;
		this.author = author;
		this.img = img;
		this.usersId = usersId;
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
	@JoinColumn(name = "ID", unique = true, nullable = false, insertable = false, updatable = false)
	public Novels getNovels() {
		return this.novels;
	}

	public void setNovels(Novels novels) {
		this.novels = novels;
	}

	@Column(name = "NOVELNAME", nullable = false, length = 30)
	public String getNovelname() {
		return this.novelname;
	}

	public void setNovelname(String novelname) {
		this.novelname = novelname;
	}

	@Column(name = "AUTHOR", length = 60)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "IMG")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "USERS_ID", precision = 22, scale = 0)
	public BigDecimal getUsersId() {
		return this.usersId;
	}

	public void setUsersId(BigDecimal usersId) {
		this.usersId = usersId;
	}

}