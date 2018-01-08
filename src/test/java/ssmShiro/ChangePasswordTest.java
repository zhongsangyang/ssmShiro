package ssmShiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ht.zsy.po.User;
import com.ht.zsy.service.Impl.UserService;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring-beans.xml"
	,"classpath:config/spring-shiro-web.xml","classpath:config/spring-mvc.xml"	
		
})
public class ChangePasswordTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void changeMimaTest(){
//		Long userId=1l;
//		String newPassword="1234";
//		userService.changePassword(userId, newPassword);
		User user=new User();
		user.setId(2l);
		user.setLocked(false);
		user.setPassword("1234");
		user.setSalt("zhong");
		user.setUsername("zhong");
		
		userService.createUser(user);
	}

}
