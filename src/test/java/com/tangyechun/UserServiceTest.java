package com.tangyechun;

import com.tangyechun.common.StateCode;
import com.tangyechun.model.User;
import com.tangyechun.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @since 2019/6/16 23:11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("用户3");
        user.setPassword("123456");
        user.setPhone("18958085792");
        user.setEmail("3160102212@zju.edu.cn");
        user.setRealname("李四");
        int code = userService.addUser(user);
        Assert.assertEquals("insert fail", StateCode.EMAIL_EXISTS.value(), code);
    }
}
