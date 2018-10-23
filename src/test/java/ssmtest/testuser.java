package ssmtest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.javen.common.RedisCacheUtil;
import com.javen.model.User;
import com.javen.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml" })
public class testuser {

	private static Logger logger = Logger.getLogger(testuser.class);

	@Resource
	private IUserService userService;

	@Resource
	private RedisCacheUtil redisCache;

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(user));

 		redisCache.hset("test", "343535", "yry22");

		System.out.println(redisCache.hget("test", "343535"));

	}

}
