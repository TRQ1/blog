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

import com.q1.blog.dao.PostDaoIpml;
import com.q1.blog.vo.PostVo;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PostDAOTest {

	@Autowired
	protected PostDaoIpml postDaoIpml;

	@Test
	public void insert() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PostVo postVo = new PostVo();
		postVo.setUserId(1);
		postVo.setContent("test");
		postVo.setToDateGmt(sdf.parse("2018-08-28 13:10:00"));
		postVo.setExcerpt("http://test.com");
		postVo.setStatus("publish");
		postVo.setCommentStatus("open");
		postVo.setPassword("qwer0987");
		postVo.setModifiedGmt(sdf.parse("2018-08-28 13:00:00"));
		postVo.setName("testname");
		postVo.setTitle("testtitle");
		postVo.setType("journal");
		postVo.setCommentCount(3);
		
		postDaoIpml.insert(postVo);
	}
	
	@Test
	public void selectList() {
		List<PostVo> postList = postDaoIpml.selectPostList();
		
		for ( PostVo postVo : postList ) {
			System.out.println(postVo.getId());
		}
		
	}

	
}
