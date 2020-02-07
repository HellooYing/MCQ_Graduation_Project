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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CloudApplication.class)
@WebAppConfiguration
public class CloudApplicationTests {
	@Autowired
	private PiDAO piDAO;
	@Test
	public void contextLoads() {
		System.out.println(piDAO.selectAll());
	}

}