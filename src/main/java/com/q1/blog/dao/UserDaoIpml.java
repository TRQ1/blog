package com.q1.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.q1.blog.utils.AbstractDao;
import com.q1.blog.vo.UserVo;

@Repository
public class UserDaoIpml extends AbstractDao implements UserDao {
	
	@Transactional
	public void insert(UserVo userVo) {
		getSqlSession().insert("User.insertUser", userVo);
		
	}

	@Override
	public UserVo selectByUsername(String loginId) {
		return getSqlSession().selectOne("User.selectByUsername", loginId);
	}

	@Override
	public UserVo selectId(int id) {
		return getSqlSession().selectOne("User.selectId", id);
	}
	
	@Override
	public List<UserVo> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList( "User.selectPostList", paramMap);
	}
	
	@Override
	public void update(UserVo userVo) {
		getSqlSession().update("User.updateUserInfo", userVo);
	}
	
	@Override
	public void delete(int id) {
		getSqlSession().delete("User.deleteUserInfo", id);
	}

	@Override
	public void insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVo findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo findByUsername(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nicknameExists(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void register(UserVo userVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeProfileInfo(UserVo newProfileInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}

}
