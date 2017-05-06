package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptPersonnelClass;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptPersonnelClass entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptPersonnelClass
 * @author MyEclipse Persistence Tools
 */
public class LwOptPersonnelClassDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptPersonnelClassDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptPersonnelClass transientInstance) {
		log.debug("saving LwOptPersonnelClass instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptPersonnelClass persistentInstance) {
		log.debug("deleting LwOptPersonnelClass instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptPersonnelClass findById(com.lw.bean.LwOptPersonnelClassId id) {
		log.debug("getting LwOptPersonnelClass instance with id: " + id);
		try {
			LwOptPersonnelClass instance = (LwOptPersonnelClass) getHibernateTemplate()
					.get("com.lw.bean.LwOptPersonnelClass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptPersonnelClass instance) {
		log.debug("finding LwOptPersonnelClass instance by example");
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
		log.debug("finding LwOptPersonnelClass instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptPersonnelClass as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptPersonnelClass instances");
		try {
			String queryString = "from LwOptPersonnelClass";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptPersonnelClass merge(LwOptPersonnelClass detachedInstance) {
		log.debug("merging LwOptPersonnelClass instance");
		try {
			LwOptPersonnelClass result = (LwOptPersonnelClass) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptPersonnelClass instance) {
		log.debug("attaching dirty LwOptPersonnelClass instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptPersonnelClass instance) {
		log.debug("attaching clean LwOptPersonnelClass instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptPersonnelClassDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptPersonnelClassDAO) ctx.getBean("LwOptPersonnelClassDAO");
	}
}