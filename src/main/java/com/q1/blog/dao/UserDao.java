package com.q1.blog.dao;

import com.q1.blog.vo.UserVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserDao {
	public void insertUser(UserVo userVo);
	
	public List<UserVo> selectList();
	
	public UserVo selectByUsername(String userId);

	public void update(UserVo userVo);
	
	public void delete(int id);
	
    UserVo findByEmail(String email);

    UserVo findByUsername(String userId);

    boolean emailExists(String email);

    boolean nicknameExists(String nickname);

    void register(UserVo userVo);

    void changeProfileInfo(UserVo newProfileInfo);

    boolean isAdmin();
}
