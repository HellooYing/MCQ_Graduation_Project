package com.bishe.cloud;

import com.bishe.cloud.dao.PiDAO;
import com.bishe.cloud.dao.UserDAO;
import com.bishe.cloud.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CloudApplication.class)
@WebAppConfiguration
public class CloudApplicationTests {
	@Autowired
	private PiDAO piDAO;
	@Autowired
	private UserDAO userDAO;
	@Test
	public void contextLoads() {

	}

	@Test
	public void testMapper(){
		System.out.println(piDAO.selectAll());

		User user = new User();
		user.setId(1);
		System.out.println(userDAO.selectByPrimaryKey(user));

		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("id",1);
		System.out.println(userDAO.selectByExample(example));

		System.out.println(userDAO.select(user));

//		User user1=new User("myy1");
//		user1.setHeadUrl("http://images.bishe.cloud.com/head/622t.png");
//		user1.setSalt("9bfb6");
//		user1.setPassword("D5B8CEE3D27223E12D8ACD44553FC9E0");
//		userDAO.insertSelective(user1);
//		System.out.println(user1.getId());
//		user1.setId(null);
//		user1.setName("myy2");
//		userDAO.insert(user1);
//		System.out.println(user1.getId());
	}

}