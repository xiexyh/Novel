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
 * Identify entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see po.Identify
 * @author MyEclipse Persistence Tools
 */

public class IdentifyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(IdentifyDAO.class);
	// property constants
	public static final String IDENTIFYNAME = "identifyname";

	public void save(Identify transientInstance) {
		log.debug("saving Identify instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Identify persistentInstance) {
		log.debug("deleting Identify instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Identify findById(java.math.BigDecimal id) {
		log.debug("getting Identify instance with id: " + id);
		try {
			Identify instance = (Identify) getSession().get("po.Identify", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Identify> findByExample(Identify instance) {
		log.debug("finding Identify instance by example");
		try {
			List<Identify> results = (List<Identify>) getSession()
					.createCriteria("po.Identify").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Identify instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Identify as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Identify> findByIdentifyname(Object identifyname) {
		return findByProperty(IDENTIFYNAME, identifyname);
	}

	public List findAll() {
		log.debug("finding all Identify instances");
		try {
			String queryString = "from Identify";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Identify merge(Identify detachedInstance) {
		log.debug("merging Identify instance");
		try {
			Identify result = (Identify) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Identify instance) {
		log.debug("attaching dirty Identify instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Identify instance) {
		log.debug("attaching clean Identify instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}