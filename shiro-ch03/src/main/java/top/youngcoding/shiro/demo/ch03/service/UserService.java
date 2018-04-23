package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.entity.User;

/**
 * @author liy
 * @date 2018/4/24
 */
@Service
public class UserService {
    public User selectByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        return user;
    }
}
