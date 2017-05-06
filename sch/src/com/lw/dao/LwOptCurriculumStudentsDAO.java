package com.lw.dao;

import java.util.List;

import com.lw.bean.LwOptCurriculumStudents;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * LwOptCurriculumStudents entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lw.bean.LwOptCurriculumStudents
 * @author MyEclipse Persistence Tools
 */
public class LwOptCurriculumStudentsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(LwOptCurriculumStudentsDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(LwOptCurriculumStudents transientInstance) {
		log.debug("saving LwOptCurriculumStudents instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LwOptCurriculumStudents persistentInstance) {
		log.debug("deleting LwOptCurriculumStudents instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LwOptCurriculumStudents findById(Integer id) {
		log.debug("getting LwOptCurriculumStudents instance with id: " + id);
		try {
			LwOptCurriculumStudents instance = (LwOptCurriculumStudents) getHibernateTemplate()
					.get("com.lw.bean.LwOptCurriculumStudents", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LwOptCurriculumStudents instance) {
		log.debug("finding LwOptCurriculumStudents instance by example");
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
		log.debug("finding LwOptCurriculumStudents instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LwOptCurriculumStudents as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all LwOptCurriculumStudents instances");
		try {
			String queryString = "from LwOptCurriculumStudents";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LwOptCurriculumStudents merge(
			LwOptCurriculumStudents detachedInstance) {
		log.debug("merging LwOptCurriculumStudents instance");
		try {
			LwOptCurriculumStudents result = (LwOptCurriculumStudents) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LwOptCurriculumStudents instance) {
		log.debug("attaching dirty LwOptCurriculumStudents instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LwOptCurriculumStudents instance) {
		log.debug("attaching clean LwOptCurriculumStudents instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LwOptCurriculumStudentsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (LwOptCurriculumStudentsDAO) ctx
				.getBean("LwOptCurriculumStudentsDAO");
	}
}