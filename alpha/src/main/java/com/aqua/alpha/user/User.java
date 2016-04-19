/**
 * 用户实体<br>
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
package com.aqua.alpha.user;

import javax.persistence.Entity;

import com.aqua.alpha.base.entity.IdEntity;
import com.aqua.alpha.security.ILoginUserInfo;

/**
 * @author limj
 *
 */
@Entity
public class User extends IdEntity implements ILoginUserInfo{

	private static final long serialVersionUID = 7936528052880905580L;
	
	private String name;
	
	private String password;
	
	private String realname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
