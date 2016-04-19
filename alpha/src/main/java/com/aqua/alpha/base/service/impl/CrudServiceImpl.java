/**
 * <br>
 * ------------------------------------------------------------<br>
 * History<br>
 * ------------------------------------------------------------<br>
 * Legend:<br>
 * 　(+) added feature<br>
 * 　(-) deleted feature<br>
 * 　(#) fixed bug<br>
 * 　(^) upgraded implementation<br>
 *<br>
 * V1.00.00 2012-2-24 limj 新建
 * @author limj
 * @since V1.00.00
 */
package com.aqua.alpha.base.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.aqua.alpha.base.dao.CrudDao;
import com.aqua.alpha.base.service.ICrudService;


/**
 * @author Administrator
 * 
 */
@Transactional
public abstract class CrudServiceImpl<T, Dao extends CrudDao<T, Long>> implements
		ICrudService<T> {

	protected Dao dao;

	public abstract void setDao(Dao dao);
	
	@Override
	public T save(T entity) {
		return dao.save(entity);
	}

	
	public Iterable<T> save(Iterable<T> entities) {
		return dao.save(entities);
	}

	@Override
	public T findOne(long id) {
		return dao.findOne(id);
	}

	@Override
	public boolean exists(long id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return dao.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<Long> ids) {
		return dao.findAll(ids);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Iterable<T> entities) {
		dao.delete(entities);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll() {
		dao.deleteAll();
	}
	
	
}
