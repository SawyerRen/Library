package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "rsy", "123", "1234@qqq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "rsy", "123", "")));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("rsy")) {
            System.out.println("已存在");
        } else {
            System.out.println("不存在");
        }
    }
}