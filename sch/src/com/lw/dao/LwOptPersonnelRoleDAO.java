package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptPersonnelRole;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptPersonnelRole entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptPersonnelRole
 * @author MyEclipse Persistence Tools
 */
public class LwOptPersonnelRoleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptPersonnelRoleDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptPersonnelRole transientInstance) {
		log.debug("saving LwOptPersonnelRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptPersonnelRole persistentInstance) {
		log.debug("deleting LwOptPersonnelRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptPersonnelRole findById(com.lw.bean.LwOptPersonnelRoleId id) {
		log.debug("getting LwOptPersonnelRole instance with id: " + id);
		try {
			LwOptPersonnelRole instance = (LwOptPersonnelRole) getHibernateTemplate()
					.get("com.lw.bean.LwOptPersonnelRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptPersonnelRole instance) {
		log.debug("finding LwOptPersonnelRole instance by example");
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
		log.debug("finding LwOptPersonnelRole instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptPersonnelRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptPersonnelRole instances");
		try {
			String queryString = "from LwOptPersonnelRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptPersonnelRole merge(LwOptPersonnelRole detachedInstance) {
		log.debug("merging LwOptPersonnelRole instance");
		try {
			LwOptPersonnelRole result = (LwOptPersonnelRole) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptPersonnelRole instance) {
		log.debug("attaching dirty LwOptPersonnelRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptPersonnelRole instance) {
		log.debug("attaching clean LwOptPersonnelRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptPersonnelRoleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptPersonnelRoleDAO) ctx.getBean("LwOptPersonnelRoleDAO");
	}
}