package com.q1.blog.service;

import com.q1.blog.vo.UserVo;
import com.q1.blog.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void insertUser(UserVo userVo) {
		userDao.insertUser(userVo);
	}
	
	public UserVo selectByUserName(String userId) {
		return userDao.selectByUsername(userId);
	}

	public void update(UserVo userVo) {
		userDao.update(userVo);
	}
	
	public void delete(int id) {
		userDao.delete(id);
	}
	  
}
