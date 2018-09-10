package com.q1.blog.dao;

import java.util.List;

import com.q1.blog.vo.PostVo;

public interface PostDao {

	public void insertPost(PostVo postVo);

	public List<PostVo> selectPostList();

	public void update(PostVo postVo);
	
	public void delete(int id);

    List<PostVo> getPostsList(int pageNumber, int pageSize);

    List<PostVo> getTopPostsList();

    PostVo getPost(Long id);

}
