package com.weyoung.wxapp;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.weyoung.wxapp.common.util.JWTUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroDemoApplicationTests {


	@Test
	public void contextLoads() {
		String token = JWTUtil.encode("123");
		System.out.println(token);
	}

	@Test
	public void testHelloWorld() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory();
		SecurityManager securityManager = factory.getInstance();

		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("pushy", "123");

		try {
			subject.login(token);

		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
		}

		Assert.assertEquals(true, subject.isAuthenticated());

		subject.logout();
	}

}
