package com.q1.blog.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.q1.blog.vo.UserVo;
import com.q1.blog.vo.PostVo;

import com.q1.blog.dao.UserDao;
import com.q1.blog.dao.PostDao;

@Controller
@SessionAttributes({"sessionUsername","sessionEmail"})
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostDao postDao;
	

	/**
	 * post 리스트 확인 
	 */
	@RequestMapping(value = "/admin/posts/list", method = RequestMethod.GET)
	public String list(
				@ModelAttribute("sessionUsername") String sessionUsername
				, @ModelAttribute("sessionEmail") String sessionEmail
				, Model model) {
		
		if ( sessionUsername.equals("") ) {
			return "redirect:/admin/login/login";
		}
		
		List<PostVo> postList = postDao.selectPostList();
	
		model.addAttribute("postList", postList);
		return "admin/posts/list";
	}

	
	/**
	 * Post 생성 
	 */
	@RequestMapping(value = "/admin/posts/doWrite", method = RequestMethod.POST)
	public String doWrite  (
			 @RequestParam("id") int id
			, @RequestParam("userId") int userId
			, @RequestParam("title") String title
			, @RequestParam("content") String content
			, @ModelAttribute("sessionUsername") String sessionUsername
			, Model model) throws IOException {
	
		  PostVo postVo = new PostVo();
		  postVo.setId(id);
		  postVo.setUserId(userId);
		  postVo.setTitle(title);
		  
	      postDao.insertPost(postVo);
	      
	      return "admin/posts/doAdd";
	      
	}
}

	
