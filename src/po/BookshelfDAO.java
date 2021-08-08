package po;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bookshelf entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.Bookshelf
 * @author MyEclipse Persistence Tools
 */

public class BookshelfDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BookshelfDAO.class);
	// property constants
	public static final String NOVELNAME = "novelname";
	public static final String AUTHOR = "author";
	public static final String IMG = "img";

	public void save(Bookshelf transientInstance) {
		log.debug("saving Bookshelf instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bookshelf persistentInstance) {
		log.debug("deleting Bookshelf instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bookshelf findById(java.math.BigDecimal id) {
		log.debug("getting Bookshelf instance with id: " + id);
		try {
			Bookshelf instance = (Bookshelf) getSession().get("po.Bookshelf",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bookshelf> findByExample(Bookshelf instance) {
		log.debug("finding Bookshelf instance by example");
		try {
			List<Bookshelf> results = (List<Bookshelf>) getSession()
					.createCriteria("po.Bookshelf").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bookshelf instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bookshelf as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bookshelf> findByNovelname(Object novelname) {
		return findByProperty(NOVELNAME, novelname);
	}

	public List<Bookshelf> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<Bookshelf> findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	public List findAll() {
		log.debug("finding all Bookshelf instances");
		try {
			String queryString = "from Bookshelf";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bookshelf merge(Bookshelf detachedInstance) {
		log.debug("merging Bookshelf instance");
		try {
			Bookshelf result = (Bookshelf) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bookshelf instance) {
		log.debug("attaching dirty Bookshelf instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bookshelf instance) {
		log.debug("attaching clean Bookshelf instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}