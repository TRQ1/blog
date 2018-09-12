package com.q1.blog;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.q1.blog.dao.UserDao;
import com.q1.blog.vo.UserVo;

@Controller
@SessionAttributes({"sessionUsername","sessionEmail"})
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserVo userVo;
	
	
	@RequestMapping(value = "/admin/login/login", method = RequestMethod.GET)
	public String login(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
	
		
		return "admin/login/login";
	}
	
	@RequestMapping(value = "/admin/login/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="loginid") String loginId
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		//userDAO.select(id)
		UserVo userVo = userDao.selectByUsername(loginId);
		if ( userVo.getPassword().equals(passwd) ) {
			// 로그인 성공
			model.addAttribute("sessionUsername", userVo.getLoginId());
			model.addAttribute("sessionEmail", userVo.getEmail());
			
			return "admin/users/list";
		} else
		{
			// 로그인 실패: 비밀번호가 다르니까.
			model.addAttribute("sessionUsername", "");
			model.addAttribute("sessionEmail", "");
		}
		
		return "redirect:/admin/login/login";
	}
	
	
	@RequestMapping(value = "/admin/login/logout", method = RequestMethod.GET)
	public String logout(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		
		model.addAttribute("sessionUsername", "");
		model.addAttribute("sessionEmail", "");
		
		return "redirect:/admin/login/login";
	}
	
}
