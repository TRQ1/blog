package com.q1.blog;

import java.util.List;

import org.codehaus.plexus.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.q1.blog.vo.UserVo;
import com.q1.blog.dao.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDAOTest {
	@Autowired
	protected UserDao userDao;
	
	@Test
	public void insert() {
		UserVo userVo = new UserVo();
		userVo.setLoginId("trq1");
		userVo.setPassword("QWer0987");
		userVo.setNickname("trq1");
		userVo.setEmail("test@test.com");
		userVo.setUrl("blog.q1.com");
		
		userDao.insert(userVo);
	}
	
	@Test
	public void selectList() {
		List<UserVo> userList = userDao.selectList();
		
		for ( UserVo userVo : userList ) {
			System.out.println(userVo.getId());
		}
		
	}
	
	
}
