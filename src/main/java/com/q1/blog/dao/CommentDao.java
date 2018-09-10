package com.q1.blog.dao;

import java.util.List;

import com.q1.blog.vo.CommentVo;

public interface CommentDao {
	
	public void insertComment(CommentVo commentVo);

	public List<CommentVo> selectCommentList();
	
	public void deleteComment(int id);

}
