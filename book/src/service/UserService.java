package service;

import pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}
