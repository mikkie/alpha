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
package com.aqua.alpha.base.service;


/**
 * @author Administrator
 *
 */
public interface ICrudService<T> {
	
	T save(T entity);

	Iterable<T> save(Iterable<T> entities);

	T findOne(long id);

	boolean exists(long id);

	Iterable<T> findAll();

	Iterable<T> findAll(Iterable<Long> ids);

	long count();

	void delete(long id);

	void delete(T entity);

	void delete(Iterable<T> entities);

	void deleteAll();

}
