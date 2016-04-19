/**
 * 
 */
package com.aqua.alpha.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author xiaxue
 *
 */
public class LoginToken extends UsernamePasswordToken{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5465831698041529487L;
	
	
	private ILoginUserInfo user;

	public LoginToken(String username, String password, ILoginUserInfo user) {
		super(username, password);
		this.user = user;
	}

	public ILoginUserInfo getUser() {
		return user;
	}

	public void setUser(ILoginUserInfo user) {
		this.user = user;
	}

}
