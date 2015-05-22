package com.hoyotech.prison.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BasicDao extends HibernateDaoSupport {

	/**
	 * 查询所有信息
	 * **/
	public List<?> queryByHql(final String hql, final Object[] param) {
		List<?> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (param != null && param.length > 0) {
							for (int i = 0; i < param.length; i++) {
								query.setString(i, param[i].toString());
							}
						}
						return query.list();
					}
				});
		return list;
	}

	/**
	 * 查询所有信息(SQL)
	 * **/
	public List queryBySql(final String hql, final Object[] param) {
		List list = null;
		try {

			list = getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createSQLQuery(hql);
					if (param != null && param.length > 0) {
						for (int i = 0; i < param.length; i++) {
							query.setString(i, param[i].toString());
						}
					}
					return query.list();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询所有信息,带分页
	 * **/
	public List<?> queryByHql(final String hql, final Object[] param,
			final int pageNumber, final int pageSize) {			
		List<?> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						try
						{
							if (param != null && param.length > 0) {
								for (int i = 0; i < param.length; i++) {
									query.setString(i, param[i].toString());
								}
							}
							query.setFirstResult((pageNumber - 1) * pageSize);
							query.setMaxResults(pageSize);	
						}
						catch (Exception e) {
							// TODO: handle exception
						} 
						return query.list();
					}
				});		
		return list;
	}

	/**
	 * 执行hql,insert或update语句
	 **/
	public Object executeHql(final String hql, final Object[] param) {
		Object object = getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (param != null && param.length > 0) {
					for (int i = 0; i < param.length; i++) {
						query.setString(i, param[i].toString());
					}
				}
				return query.executeUpdate();
			}
		});
		return object;
	}

	/**
	 * 执行hql语句，返回唯一int类型结果，用户查询总数
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public int getCount(final String hql, final Object[] param) {
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (param != null && param.length > 0) {
							for (int i = 0; i < param.length; i++) {
								query.setString(i, param[i].toString());
							}
						}
						return query.uniqueResult();
					}
				});
		if (count != null) {
			return count.intValue();
		} else {
			return 0;
		}

	}

	/**
	 * 执行hql语句，返回唯一结果
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Object queryByHqlReturnUnique(final String hql, final Object[] param) {
		Object object = getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (param != null && param.length > 0) {
							for (int i = 0; i < param.length; i++) {
								query.setString(i, param[i].toString());
							}
						}
						return query.uniqueResult();
					}
				});
		return object;
	}

	/**
	 * 保存一条记录，返回主键ID
	 * 
	 * @param obj
	 * @return
	 */
	public String save(Object obj) {

		String id = "";
		try {
			id = (String) getHibernateTemplate().save(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 根据ID获取一条记录的详细信息
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object detail(Class<?> clazz, String id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 根据ID获取一条记录的详细信息
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object detail(Class<?> clazz, int id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 修改一条记录的详细信息
	 * 
	 * @param obj
	 */
	public void update(Object obj) {
		// try {
		getHibernateTemplate().update(obj);

		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 执行hql语句，返回唯一结果
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Object queryByHqlReturnUnique(final String hql,
			final Object[] param, final int pageNumber, final int pageSize) {
		Object object = getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (param != null && param.length > 0) {
							for (int i = 0; i < param.length; i++) {
								query.setString(i, param[i].toString());
							}
						}
						query.setFirstResult((pageNumber - 1) * pageSize);
						query.setMaxResults(pageSize);
						return query.uniqueResult();
					}
				});
		return object;
	}
}
