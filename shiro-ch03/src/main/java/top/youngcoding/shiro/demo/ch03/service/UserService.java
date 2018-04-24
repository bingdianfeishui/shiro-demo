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
        user.setId(1L);
        user.setUsername(username);
        user.setPassword("a19ce082fe9f17c23086e539b3ebca390f2019e53cdcd5e37345cbf6ebc9c3bd9cdf84ae5189a3af5f7c32176398d26d");
        return user;
    }
}
