package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.q1.blog.vo.PostVo;

@Repository
public class PostDaoIpml extends SqlSessionDaoSupport implements PostDao {

	public void insert(PostVo postVo) {
		getSqlSession().insert("Post.insertPost", postVo);
	}
	
	@Override
	public List<PostVo> selectPostList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Post.selectPostList", paramMap);
	}
	
	@Override
	public void update(PostVo postVo) {
		getSqlSession().update("Post.updatePostPage", postVo);
	}
	
	@Override
	public void delete(int id) {
		getSqlSession().delete("Post.deletePostPage", id);
	}

	@Override
	public void insertPost(PostVo postVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostVo> getPostsList(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostVo> getTopPostsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostVo getPost(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
