package com.wz.service;

import com.wz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Created by zhenwang on 2018/3/2.
 */
@ContextConfiguration("classpath*:/application-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
       boolean b1 = userService.hasMatchUser("admin", "123456");
       boolean b2 = userService.hasMatchUser("admin", "11111");
       assertTrue(b1);
       assertTrue(!b2);
    }

    @Test
    public void findUserByUsername() {
        User user = userService.findUserByName("admin");
        assertEquals("admin", user.getUserName());
    }
}
