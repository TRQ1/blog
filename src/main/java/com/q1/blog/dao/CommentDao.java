package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.q1.blog.vo.CommentVo;

public class CommentDao extends SqlSessionDaoSupport {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(CommentVo commentVo) {
		getSqlSession().insert("Comment.insertComment", commentVo);
	}
	
	public List<CommentVo> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList( "Comment.selectCommentList", paramMap);
	}	
	
	
}
