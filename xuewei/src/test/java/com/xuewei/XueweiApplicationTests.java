package com.xuewei;

import com.xuewei.mongodb.service.HisService;
import com.xuewei.mongodb.vo.His;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XueweiApplicationTests {


	@Resource
	DataSource dataSource;
	@Resource
	HisService hisService;

	/**
	 * druid数据源测试
	 * @throws SQLException
	 */
	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}


	@Test
	public void mongo(){
		List<His> result = new ArrayList<His>();
		result = hisService.queryHis("num1");
		System.out.println();
	}


}
