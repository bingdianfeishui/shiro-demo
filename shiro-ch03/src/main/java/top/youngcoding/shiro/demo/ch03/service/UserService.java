package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.dao.UserMapper;
import top.youngcoding.shiro.demo.ch03.entity.User;

/**
 * @author liy
 * @date 2018/4/24
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
