package com.q1.blog.controller;

import java.util.List;

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
				, @RequestParam("id") int id
				, @RequestParam("userId") int userId
				, @RequestParam("author") String author
				, @RequestParam("content") String content
				, Model model) {
		
		CommentVo commentVo = new CommentVo();
		commentVo.setId(id);
		commentVo.setUserId(id);
		commentVo.setAuthor(author);
		commentVo.setContent(content);

		List<CommentVo> commentList = commentDao.selectCommentList();
	
		model.addAttribute("commetList", commentList);
		return "admin/comments/list";
	}

}
