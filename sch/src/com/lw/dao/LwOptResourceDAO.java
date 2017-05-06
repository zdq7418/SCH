package com.lw.dao;

import com.lw.bean.LwOptResource;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptResource entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptResource
 * @author MyEclipse Persistence Tools
 */
public class LwOptResourceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptResourceDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptResource transientInstance) {
		log.debug("saving LwOptResource instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptResource persistentInstance) {
		log.debug("deleting LwOptResource instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptResource findById(Integer id) {
		log.debug("getting LwOptResource instance with id: " + id);
		try {
			LwOptResource instance = (LwOptResource) getHibernateTemplate()
					.get("com.lw.bean.LwOptResource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptResource instance) {
		log.debug("finding LwOptResource instance by example");
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
		log.debug("finding LwOptResource instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptResource as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptResource instances");
		try {
			String queryString = "from LwOptResource";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptResource merge(LwOptResource detachedInstance) {
		log.debug("merging LwOptResource instance");
		try {
			LwOptResource result = (LwOptResource) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptResource instance) {
		log.debug("attaching dirty LwOptResource instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptResource instance) {
		log.debug("attaching clean LwOptResource instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptResourceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptResourceDAO) ctx.getBean("LwOptResourceDAO");
	}
}