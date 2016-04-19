/**
 用户服务接口* 
 */
package com.aqua.alpha.user.service;

import com.aqua.alpha.base.service.ICrudService;
import com.aqua.alpha.user.User;

/**
 * @author xiaxue
 *
 */
public interface IUserService extends ICrudService<User>{

	public User findOneByName(String name);

}
