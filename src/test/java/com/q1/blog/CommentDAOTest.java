package com.q1.blog;

import java.util.List;
import java.text.SimpleDateFormat;

import org.codehaus.plexus.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.q1.blog.dao.CommentDao;
import com.q1.blog.vo.CommentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CommentDAOTest {
	
	@Autowired
	protected CommentDao commentDao;
	
	@Test
	public void insert() throws Exception {
	
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		CommentVo commentVo = new CommentVo();
		commentVo.setUserId(1);
		commentVo.setPostId(1);
		commentVo.setToDateGmt(sdf.parse("2018-08-28 13:00:00"));
		commentVo.setAuthor("test1");
		commentVo.setAuthorEmail("test@test1.com");
		commentVo.setAuthorUrl("http://test1.com");
		commentVo.setContent("test nnnn");
		commentVo.setType("comment");
		
		commentDao.insert(commentVo);
	}
	
	@Test
	public void selectList() {
		List<CommentVo> commentList = commentDao.selectList();
		
		for ( CommentVo commentVo : commentList ) {
			System.out.println(commentVo.getId());
		}
		
	}

}
