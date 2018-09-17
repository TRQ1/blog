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
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.q1.blog.dao.UserDao;
import com.q1.blog.vo.PostVo;
import com.q1.blog.dao.PostDao;
import com.q1.blog.vo.CommentVo;
import com.q1.blog.dao.CommentDao;


@Controller
@SessionAttributes({"sessionUsername"})
public class CommentController {
	
	@Autowired
	private CommentDao commentDao;
	
	/**
	 * Comment 리스트 확인 
	 */
	@RequestMapping(value = "/admin/comments/list", method = RequestMethod.GET)
	public String list(
				@ModelAttribute("sessionUsername") String sessionUsername
				, Model model) {
		
		if ( sessionUsername.equals("") ) {
			return "redirect:/admin/login/login";
		}
		
		List<CommentVo> commentList = commentDao.selectCommentList();
	
		model.addAttribute("commetList", commentList);
		return "admin/comments/list";
	}

}
