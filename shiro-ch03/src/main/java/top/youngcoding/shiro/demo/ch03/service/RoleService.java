package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.dao.UserMapper;
import top.youngcoding.shiro.demo.ch03.entity.Role;
import top.youngcoding.shiro.demo.ch03.entity.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author liy
 * @date 2018/4/24
 */
@Service
public class RoleService {
    @Resource
    private UserMapper userMapper;

    public List<Role> selectByUser(User user) {
        return userMapper.selectRoles(user.getId());
    }
}
