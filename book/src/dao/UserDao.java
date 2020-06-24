package dao;

import pojo.User;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/22 15:18
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询
     *
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(User user);


}
