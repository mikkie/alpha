/**
 * 登录控制器
 */
package com.aqua.alpha.login;


import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqua.alpha.security.LoginToken;
import com.aqua.alpha.security.ShiroDbRealm.ShiroUser;
import com.aqua.alpha.user.User;
import com.aqua.alpha.user.service.IUserService;
import com.aqua.alpha.util.JsonMapperHolder;

/**
 * @author xiaxue
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("")
	public String index(){
		Subject currentUser = SecurityUtils.getSubject();
		//未验证
		if (!currentUser.isAuthenticated()) {
			return "login";
		}
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping(value="do",method=RequestMethod.POST)
	public String login(@RequestParam("name")String name,@RequestParam("password")String password,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.findOneByName(name);
		Subject currentUser = SecurityUtils.getSubject();
		boolean result = false;
		if (!currentUser.isAuthenticated()) {
			result = login(currentUser, name, password, model, user);
		} else {// 重复登录
			ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
			if (!shiroUser.getUserInfo().getName().equalsIgnoreCase(name)) {// 如果登录名不同
				currentUser.logout();
				result = login(currentUser, name, password, model, user);
			} else {
				result = true;
			}
		}
		if (result) {
			map.put("success", user);
		} else {
			map.put("error", "用户名或密码错误");

		}
		return JsonMapperHolder.toJson(map);
	}


	private boolean login(Subject currentUser, String name, String password,
			Model model, User user) {
		LoginToken token = new LoginToken(name, password, user);
		token.setRememberMe(false);
		try {
			currentUser.login(token);
			return true;
		} catch (UnknownAccountException uae) {
			model.addAttribute("error", "用户名或密码错误");
		} catch (IncorrectCredentialsException ice) {
			model.addAttribute("error", "用户名或密码错误");
		} catch (LockedAccountException lae) {
			model.addAttribute("error", "用户名或密码错误");
		} catch (AuthenticationException ae) {
			model.addAttribute("error", "用户名或密码错误");
		}
		return false;
	}
}
