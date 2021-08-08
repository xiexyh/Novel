package po;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Chapters entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.Chapters
 * @author MyEclipse Persistence Tools
 */

public class ChaptersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ChaptersDAO.class);
	// property constants
	public static final String CHAPTERNAME = "chaptername";
	public static final String CONTENTS = "contents";

	public void save(Chapters transientInstance) {
		log.debug("saving Chapters instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chapters persistentInstance) {
		log.debug("deleting Chapters instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chapters findById(java.math.BigDecimal id) {
		log.debug("getting Chapters instance with id: " + id);
		try {
			Chapters instance = (Chapters) getSession().get("po.Chapters", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Chapters> findByExample(Chapters instance) {
		log.debug("finding Chapters instance by example");
		try {
			List<Chapters> results = (List<Chapters>) getSession()
					.createCriteria("po.Chapters").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Chapters instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Chapters as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Chapters> findByChaptername(Object chaptername) {
		return findByProperty(CHAPTERNAME, chaptername);
	}

	public List<Chapters> findByContents(Object contents) {
		return findByProperty(CONTENTS, contents);
	}

	public List findAll() {
		log.debug("finding all Chapters instances");
		try {
			String queryString = "from Chapters";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chapters merge(Chapters detachedInstance) {
		log.debug("merging Chapters instance");
		try {
			Chapters result = (Chapters) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chapters instance) {
		log.debug("attaching dirty Chapters instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chapters instance) {
		log.debug("attaching clean Chapters instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}