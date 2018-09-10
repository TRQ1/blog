package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.q1.blog.vo.CommentVo;

@Repository
public class CommentDaoIpml extends SqlSessionDaoSupport implements CommentDao {

	@Override
	public void insertComment(CommentVo commentVo) {
		getSqlSession().insert("Comment.insertComment", commentVo);
	}

	@Override
	public List<CommentVo> selectCommentList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList( "Comment.selectCommentList", paramMap);
	}

	@Override
	public void deleteComment(int id) {
		getSqlSession().delete("Comment.deleteComment", id);
	}


}
