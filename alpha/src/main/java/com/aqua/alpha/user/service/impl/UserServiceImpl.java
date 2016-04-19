/**
 接口服务实现类* 
 */
package com.aqua.alpha.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqua.alpha.base.service.impl.CrudServiceImpl;
import com.aqua.alpha.user.User;
import com.aqua.alpha.user.dao.UserDao;
import com.aqua.alpha.user.service.IUserService;

/**
 * @author xiaxue
 *
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl extends CrudServiceImpl<User, UserDao> implements IUserService{

	@Override
	@Autowired
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User findOneByName(String name) {
		return dao.findOneByName(name);
	}

}
