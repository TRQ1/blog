package com.q1.blog.controller;

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
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserVo userVo;

	@RequestMapping(value = "/admin/login/login", method = RequestMethod.GET)
	public String login(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {

		System.out.println("["+sessionUsername+"]");
		if ( sessionUsername == null || sessionUsername.equals("") ) {
			// 로그인이 안되어 있는 상
		} else {
			// 로그인이 되어이 있는 상태
			return "redirect:/admin/users/list";
		}
		
		return "admin/login/login";
	}
	
	@RequestMapping(value = "/admin/login/relogin", method = RequestMethod.GET)
	public String relogin(
			@SessionAttribute(required=false, value="sessionUsername") String sessionUsername
			, Model model) {
	
		
		return "admin/login/relogin";
	}
	
	@RequestMapping(value = "/admin/login/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="loginid") String loginId
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		//userDAO.select(id)
		UserVo userVo = userDao.selectByUsername(loginId);
	
		if ( userVo == null ) {
			// 다시 로그인을 하세요.
			return "admin/login/relogin";
		}
		
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

	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String list(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @ModelAttribute("sessionEmail") String sessionEmail
			, @RequestParam(value="loginid", defaultValue="") String username
			, @RequestParam(value="id", defaultValue="0") int id
			, Model model) {

		if ( sessionUsername.equals("") ) {
			return "redirect:/admin/login/login";
		}

		List<UserVo> userList = userDao.selectList();

		model.addAttribute("userList", userList);

		System.out.println(sessionUsername);

		return "admin/users/list";
	}

	/**
	 * 계정 관리 정보 확인 
	 */
	@RequestMapping(value = "/admin/users/info", method = RequestMethod.GET)
	public String info(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="id") int id
			, @RequestParam(required=false, value="loginid") String username
			, Model model) {

		UserVo user = userDao.selectId(id);

		model.addAttribute("userVO", user);

		System.out.println(sessionUsername);

		return "admin/users/info";
	}


	/**
	 * 계정 정보 변경 
	 */
	@RequestMapping(value = "/admin/users/edit", method = RequestMethod.GET)
	public String edit(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="id") int id
			, @RequestParam(required=false, value="username") String username
			, Model model) {

		UserVo user = userDao.selectId(id);

		model.addAttribute("userVO", user);

		System.out.println(sessionUsername);

		return "admin/users/edit";
	}


	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String add(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {

		return "admin/users/add";
	}

	@RequestMapping(value = "/admin/users/doAdd", method = RequestMethod.POST)
	public String doAdd(
			@RequestParam(value="loginid") String loginid
			, @RequestParam(value="email") String email
			, @ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {

		model.addAttribute("loginid", loginid);
		model.addAttribute("email", email);

		UserVo userVO = new UserVo();
		userVO.setLoginId(loginid);
		userVO.setEmail(email);

		userDao.insertUser(userVO);

		return "admin/users/doAdd";
	}

	@RequestMapping(value = "/admin/users/doEdit", method = RequestMethod.POST)
	public String doAdd(
			@RequestParam(value="id") int id
			, @RequestParam(value="loginid") String loginid
			, @RequestParam(value="email") String email
			, @RequestParam(value="nickname") String nickname
			, @RequestParam(value="passwd") String passwd
			, @ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {

		model.addAttribute("loginid", loginid);
		model.addAttribute("email", email);

		UserVo userVO = new UserVo();
		userVO.setId(id);
		userVO.setLoginId(loginid);
		userVO.setEmail(email);
		userVO.setNickname(nickname);
		userVO.setPassword(passwd);

		userDao.update(userVO);

		return "admin/users/doAdd";
	}
	
}
