/**
 * 
 */
package com.aqua.alpha.security;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.aqua.alpha.user.User;
import com.aqua.alpha.user.service.IUserService;

/**
 * @author xiaxue
 *
 */
public class ShiroDbRealm extends AuthorizingRealm{
	
	private static final String ALGORITHM = "MD5";
	
	private IUserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		LoginToken loginToken = (LoginToken)token;
		String username = loginToken.getUsername();
		User user = userService.findOneByName(username);
		if(user == null){
			return null;
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
				ALGORITHM);
		setCredentialsMatcher(matcher);
	}
	
	
	
	public static class ShiroUser implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 715374314988443069L;
		
		
		private ILoginUserInfo userInfo;

		
		public ShiroUser(ILoginUserInfo userInfo) {
			this.userInfo = userInfo;
		}
		

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return userInfo.getName();
		}

		public ILoginUserInfo getUserInfo() {
			return userInfo;
		}
	}
	

}
