package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptMansion;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptMansion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptMansion
 * @author MyEclipse Persistence Tools
 */
public class LwOptMansionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptMansionDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptMansion transientInstance) {
		log.debug("saving LwOptMansion instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptMansion persistentInstance) {
		log.debug("deleting LwOptMansion instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptMansion findById(Integer id) {
		log.debug("getting LwOptMansion instance with id: " + id);
		try {
			LwOptMansion instance = (LwOptMansion) getHibernateTemplate().get(
					"com.lw.bean.LwOptMansion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptMansion instance) {
		log.debug("finding LwOptMansion instance by example");
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
		log.debug("finding LwOptMansion instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptMansion as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptMansion instances");
		try {
			String queryString = "from LwOptMansion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptMansion merge(LwOptMansion detachedInstance) {
		log.debug("merging LwOptMansion instance");
		try {
			LwOptMansion result = (LwOptMansion) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptMansion instance) {
		log.debug("attaching dirty LwOptMansion instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptMansion instance) {
		log.debug("attaching clean LwOptMansion instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptMansionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptMansionDAO) ctx.getBean("LwOptMansionDAO");
	}
}