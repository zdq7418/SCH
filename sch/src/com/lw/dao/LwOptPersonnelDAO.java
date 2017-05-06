package com.lw.dao;

import com.lw.bean.LwOptPersonnel;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptPersonnel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see LwOptPersonnel
 * @author MyEclipse Persistence Tools
 */
public class LwOptPersonnelDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptPersonnelDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptPersonnel transientInstance) {
		log.debug("saving LwOptPersonnel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptPersonnel persistentInstance) {
		log.debug("deleting LwOptPersonnel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptPersonnel findById(Integer id) {
		log.debug("getting LwOptPersonnel instance with id: " + id);
		try {
			LwOptPersonnel instance = (LwOptPersonnel) getHibernateTemplate()
					.get("com.lw.bean.LwOptPersonnel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptPersonnel instance) {
		log.debug("finding LwOptPersonnel instance by example");
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
		log.debug("finding LwOptPersonnel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptPersonnel as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptPersonnel instances");
		try {
			String queryString = "from LwOptPersonnel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptPersonnel merge(LwOptPersonnel detachedInstance) {
		log.debug("merging LwOptPersonnel instance");
		try {
			LwOptPersonnel result = (LwOptPersonnel) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptPersonnel instance) {
		log.debug("attaching dirty LwOptPersonnel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptPersonnel instance) {
		log.debug("attaching clean LwOptPersonnel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptPersonnelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptPersonnelDAO) ctx.getBean("LwOptPersonnelDAO");
	}
}