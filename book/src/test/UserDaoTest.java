package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin","admin"));

    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"admin","123456","123@qq.com")));
    }
}