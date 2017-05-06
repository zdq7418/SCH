package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptFloor;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptFloor entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptFloor
 * @author MyEclipse Persistence Tools
 */
public class LwOptFloorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptFloorDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptFloor transientInstance) {
		log.debug("saving LwOptFloor instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptFloor persistentInstance) {
		log.debug("deleting LwOptFloor instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptFloor findById(Integer id) {
		log.debug("getting LwOptFloor instance with id: " + id);
		try {
			LwOptFloor instance = (LwOptFloor) getHibernateTemplate().get(
					"com.lw.bean.LwOptFloor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptFloor instance) {
		log.debug("finding LwOptFloor instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LwOptFloor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LwOptFloor as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptFloor instances");
		try {
			String queryString = "from LwOptFloor";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptFloor merge(LwOptFloor detachedInstance) {
		log.debug("merging LwOptFloor instance");
		try {
			LwOptFloor result = (LwOptFloor) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptFloor instance) {
		log.debug("attaching dirty LwOptFloor instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptFloor instance) {
		log.debug("attaching clean LwOptFloor instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptFloorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LwOptFloorDAO) ctx.getBean("LwOptFloorDAO");
	}
}