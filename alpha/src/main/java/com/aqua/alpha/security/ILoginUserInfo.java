/**
 * 
 */
package com.aqua.alpha.security;

/**
 * @author xiaxue
 *
 */
public interface ILoginUserInfo {
	
	/**
	 * 获取用户id
	 * @return
	 */
	public Long getId();
	
	/**
	 * 获取登录名
	 * @return
	 */
	public String getName();
	
	/**
	 * 获取真实姓名
	 * @return
	 */
	public String getRealname();
	
	
	/**
	 * 获取密码
	 * @return
	 */
	public String getPassword();

}
