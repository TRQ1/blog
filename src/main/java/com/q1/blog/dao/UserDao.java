package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.q1.blog.vo.UserVo;


public class UserDao extends SqlSessionDaoSupport {
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(UserVo userVo) {
		getSqlSession().insert("User.insertUser", userVo);
	}
	
	public List<UserVo> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList( "User.selectUserList", paramMap);
	}
}
