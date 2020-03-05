package com.bishe.cloud;

import com.alibaba.fastjson.JSON;
import com.bishe.cloud.dao.MonitorDAO;
import com.bishe.cloud.dao.PiDAO;
import com.bishe.cloud.dao.UserAuthorityDAO;
import com.bishe.cloud.dao.UserDAO;
import com.bishe.cloud.model.*;
import com.bishe.cloud.service.MonitorService;
import com.bishe.cloud.service.PiService;
import com.bishe.cloud.service.ResponseService;
import com.bishe.cloud.service.SensorService;
import com.bishe.cloud.util.CloudUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CloudApplication.class)
@WebAppConfiguration
public class CloudApplicationTests {
    @Resource
    private PiDAO piDAO;
    @Resource
    private UserDAO userDAO;
    @Resource
    UserAuthorityDAO userAuthorityDAO;
    @Resource
    MonitorDAO monitorDAO;

    @Resource
    ResponseService responseService;
    @Resource
    SensorService sensorService;
    @Resource
    PiService piService;
    @Resource
    MonitorService monitorService;


    @Test
    public void contextLoads() {
        List<SensorDataRecord> list=new ArrayList<>();
        list.add(new SensorDataRecord(1l,1,1l,"1"));
        list.add(new SensorDataRecord(1l,1,1l,"2"));
        sensorService.insertSensorDataRecord(list);
    }

//    @Test
//    public void testPost(){
//        Map<String, String> map=new HashMap<>();
//        map.put("abc","abc");
//        String a = CloudUtil.sendPost("http://127.0.0.1:8000/addMonitor", map);
//        System.out.println(a);
//        System.out.println(a.length());
//    }

    @Test
    public void testMapper() {
        System.out.println(piDAO.selectAll());

        User user = new User();
        user.setId(1);
        System.out.println(userDAO.selectByPrimaryKey(user));

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", 1);
        System.out.println(userDAO.selectByExample(example));

        System.out.println(userDAO.select(user));

         User user1=new User("myy1");
         user1.setHeadUrl("http://images.bishe.cloud.com/head/622t.png");
         user1.setSalt("9bfb6");
         user1.setPassword("D5B8CEE3D27223E12D8ACD44553FC9E0");
         userDAO.insertSelective(user1);
         System.out.println(user1.getId());
         user1.setId(null);
         user1.setName("myy2");
         userDAO.insert(user1);
         System.out.println(user1.getId());

        User user2 = new User("myy1");
        user2.setId(user1.getId());
        System.out.println(userDAO.select(user2));
        user2.setId(user1.getId()+10086);
        System.out.println(userDAO.select(user2));
    }

	@Test
	public void testDevice(){
		Pi pi=new Pi(1l,"1,1");
		piService.addPi(pi);
		Assert.assertEquals(pi.getWarehouseId(),piService.getPi(pi.getId()).getWarehouseId());
		Assert.assertEquals(pi.getLocation(),piService.getPi(pi.getId()).getLocation());
		pi.setLocation("2,1");
		piService.updatePi(pi);
		Assert.assertEquals("2,1",piService.getPi(pi.getId()).getLocation());

		ResponseDeviceType responseDeviceType = new ResponseDeviceType("蜂鸣器1");
		responseService.addResponseDeviceType(responseDeviceType);
		Assert.assertEquals(responseDeviceType.getName(),responseService.getResponseDeviceType(responseDeviceType.getId()).getName());
		responseDeviceType.setName("蜂鸣器");
		responseService.renameResponseDeviceType(responseDeviceType.getId(),responseDeviceType.getName());
		Assert.assertEquals("蜂鸣器",responseService.getResponseDeviceType(responseDeviceType.getId()).getName());

		ResponseDevice responseDevice = new ResponseDevice(responseDeviceType.getId(), 1l, pi.getId(), "1,1");
		responseService.addResponseDevice(responseDevice);
		Assert.assertEquals(responseDevice.getLocation(),responseService.getResponseDevice(responseDevice.getId()).getLocation());
		responseDevice.setLocation("2,1");
		responseService.updateResponseDeviceById(responseDevice);
		Assert.assertEquals("2,1",responseService.getResponseDevice(responseDevice.getId()).getLocation());

		SensorType sensorType=new SensorType("温度湿度传感器");
		sensorService.addSensorType(sensorType);
		Assert.assertEquals(sensorType.getName(),sensorService.getSensorType(sensorType.getId()).getName());
		sensorType.setValueType(2);
		sensorService.updateSensorType(sensorType);
		Assert.assertEquals(sensorType.getValueType(),sensorService.getSensorType(sensorType.getId()).getValueType());
		Sensor sensor=new Sensor(sensorType.getId(),1l,pi.getId(),"1,1");
		sensorService.addSensor(sensor);
		Assert.assertEquals(sensor.getLocation(),sensorService.getSensor(sensor.getId()).getLocation());
		sensor.setLocation("2,1");
		sensorService.updateSensorById(sensor);
		Assert.assertEquals("2,1",sensorService.getSensor(sensor.getId()).getLocation());

        Monitor monitor=new Monitor(1l,"[1]","10","maocaoqiu@gmail.com",1000000,false,"!,20,25");
        monitorService.addMonitor(monitor);
    }

}