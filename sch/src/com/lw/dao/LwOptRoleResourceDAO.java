package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptRoleResource;
import com.lw.bean.LwOptRoleResourceId;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptRoleResource entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see LwOptRoleResource
 * @author MyEclipse Persistence Tools
 */
public class LwOptRoleResourceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptRoleResourceDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptRoleResource transientInstance) {
		log.debug("saving LwOptRoleResource instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptRoleResource persistentInstance) {
		log.debug("deleting LwOptRoleResource instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptRoleResource findById(LwOptRoleResourceId id) {
		log.debug("getting LwOptRoleResource instance with id: " + id);
		try {
			LwOptRoleResource instance = (LwOptRoleResource) getHibernateTemplate()
					.get("com.lw.bean.LwOptRoleResource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptRoleResource instance) {
		log.debug("finding LwOptRoleResource instance by example");
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
		log.debug("finding LwOptRoleResource instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptRoleResource as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptRoleResource instances");
		try {
			String queryString = "from LwOptRoleResource";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptRoleResource merge(LwOptRoleResource detachedInstance) {
		log.debug("merging LwOptRoleResource instance");
		try {
			LwOptRoleResource result = (LwOptRoleResource) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptRoleResource instance) {
		log.debug("attaching dirty LwOptRoleResource instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptRoleResource instance) {
		log.debug("attaching clean LwOptRoleResource instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptRoleResourceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptRoleResourceDAO) ctx.getBean("LwOptRoleResourceDAO");
	}
}