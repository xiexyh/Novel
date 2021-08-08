package po;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Novels entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.Novels
 * @author MyEclipse Persistence Tools
 */

public class NovelsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NovelsDAO.class);
	// property constants
	public static final String NOVELNAME = "novelname";
	public static final String AUTHOR = "author";
	public static final String STATE = "state";
	public static final String NUM = "num";
	public static final String SUTOU = "sutou";
	public static final String IMG = "img";

	public void save(Novels transientInstance) {
		log.debug("saving Novels instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Novels persistentInstance) {
		log.debug("deleting Novels instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Novels findById(java.math.BigDecimal id) {
		log.debug("getting Novels instance with id: " + id);
		try {
			Novels instance = (Novels) getSession().get("po.Novels", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Novels> findByExample(Novels instance) {
		log.debug("finding Novels instance by example");
		try {
			List<Novels> results = (List<Novels>) getSession()
					.createCriteria("po.Novels").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Novels instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Novels as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Novels> findByNovelname(Object novelname) {
		return findByProperty(NOVELNAME, novelname);
	}

	public List<Novels> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<Novels> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Novels> findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List<Novels> findBySutou(Object sutou) {
		return findByProperty(SUTOU, sutou);
	}

	public List<Novels> findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	public List findAll() {
		log.debug("finding all Novels instances");
		try {
			String queryString = "from Novels";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Novels merge(Novels detachedInstance) {
		log.debug("merging Novels instance");
		try {
			Novels result = (Novels) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Novels instance) {
		log.debug("attaching dirty Novels instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Novels instance) {
		log.debug("attaching clean Novels instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}