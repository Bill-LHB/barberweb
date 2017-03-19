package com.lhb.barber.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhb.barber.model.Role;
import com.lhb.barber.model.User;
import com.lhb.barber.server.SystemServer;
import com.lhb.barber.server.UserServer;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserServer userServer;

	@Autowired
	private SystemServer systemServer;

	/**
	 * 添加用户
	 * 
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adduser")
	public String addRole(User user, Model model) {
		model.addAttribute("operation", "adduser");
		return "user/add_user";
	}

	/**
	 * 更新用户
	 * 
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateuser/{user_id}", method = RequestMethod.GET)
	public String updateUser(@PathVariable Integer user_id, Model model) {
		User user = userServer.getUserById(user_id);
		model.addAttribute("user", user);
		model.addAttribute("operation", "updateuser");
		return "user/add_user";
	}

	/**
	 * 审核用户
	 * 
	 * @param user_id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/audituser/{user_id}", method = RequestMethod.GET)
	public String auditUser(@PathVariable Integer user_id, Model model) {
		User user = userServer.getUserById(user_id);
		List<Role> roleList = systemServer.getAllRole();
		Role userrole = systemServer.getRoleById(user.getRole().getRole_id());	
		model.addAttribute("user", user);
		model.addAttribute("roleList", roleList);
	
		model.addAttribute("userrole", userrole);
		

		model.addAttribute("operation", "audituser");
		return "user/add_user";
	}

	private String add(User user) {
		if (!userServer.addUser(user)) {
			return "添加用户失败";
		}
		return "";
	}

	private String audit(User user, Integer roleid, Integer stateid) {
		User u = userServer.getUserById(user.getUser_id());
		Role role = systemServer.getRoleById(roleid);
		
		u.setDescription(user.getDescription());
		if (!userServer.updateUser(u)) {
			return "审核用户失败";
		}
		return "";

	}

	private String update(User user, String oldpassword) {
		User u = userServer.getUserById(user.getUser_id());
		if (!u.getPassword().equals(oldpassword)) {
			return "修改失败,密码有误！";
		}
		u.setPassword(user.getPassword());
		u.setDescription(user.getDescription());
		if (!userServer.updateUser(u)) {
			return "修改用户失败";
		}
		return "";

	}

	/**
	 * 
	 * @param operation
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/operation", method = RequestMethod.POST)
	public String operationUser(String operation, User user, Model model, Integer roleid, Integer stateid,
			String oldpassword) {
		String message = "";
		switch (operation) {
		case "adduser":
			message = add(user);
			break;
		case "updateuser":
			message = update(user, oldpassword);
			break;
		case "audituser":
			message = audit(user, roleid, stateid);
			break;
		}
		model.addAttribute("message", message);
		return "redirect:/user/alluser.do";
	}

	/**
	 * 删除用户
	 * 
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteuser/{user_id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer user_id, Model model) {
		String message = "";
		User user = userServer.getUserById(user_id);
		if (!userServer.deleteUser(user)) {
			message = "删除用户失败！";
		}
		model.addAttribute("user", "");
		model.addAttribute("message", message);
		return "redirect:/user/alluser.do";
	}

	/**
	 * 所有用户
	 * 
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/alluser")
	public String getAllUser(String message, Model model) {
		if (message != null && !message.equals("")) {
			model.addAttribute("message", message);
		}
		List<User> userList = userServer.getAllUser();
		model.addAttribute("userList", userList);
		return "user/list_user";
	}

	/**
	 * 登录用户检查
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user, Model model, HttpSession session) {		
		User u=userServer.checkUser(user.getUser_name(), user.getPassword());
		if (u == null) {
			model.addAttribute("message", "登录失败");
			return "user/login";
		}
		User presentUser = (User) userServer.getUserById(u.getUser_id());
		session.setAttribute("presentUser", presentUser);
		return "main";
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String loginOut(Model model, HttpSession session) {
		session.setAttribute("presentUser", "");
		
		return "redirect:/welcome/login.do";
	}

	/**
	 * 交接班
	 * 
	 * @return
	 */
	@RequestMapping("/switchoverUser")
	public String exchangeUser() {
		return "login/switchover_user";
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping("/checkpassword")
	public String checkpassword(HttpSession session,String checkpassword,String oldpassword, Model model) {
		String message="";
		User u=(User) session.getAttribute("presentUser");
		if(u.getPassword().equals(oldpassword)){
			u.setPassword(checkpassword);
			message= "修改密码失败！";
		}
		model.addAttribute("message", message);	
		return "user/list_user";
	}
	
	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping("/changepassword")
	public String password(HttpSession session,String checkpassword,String oldpassword, Model model) {
		return "user/changepassword";
	}
	
}
