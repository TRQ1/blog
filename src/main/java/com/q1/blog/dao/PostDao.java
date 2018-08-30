package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.q1.blog.vo.PostVo;

public class PostDao extends SqlSessionDaoSupport {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(PostVo postVo) {
		getSqlSession().insert("Post.insertPost", postVo);
	}
	
	public List<PostVo> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList( "Post.selectPostList", paramMap);
	}
	
	public List<PostVo> seliectPostList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Post.selectPostList", paramMap);
	}
	
	public void update(PostVo postVo) {
		getSqlSession().update("Post.updatePostPage", postVo);
	}
	
	public void delete(int id) {
		getSqlSession().delete("Post.deletePostPage", id);
	}
	
}
