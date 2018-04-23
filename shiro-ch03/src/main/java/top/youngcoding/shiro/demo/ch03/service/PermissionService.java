package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
import top.youngcoding.shiro.demo.ch03.entity.User;

import java.util.Set;

/**
 * @author liy
 * @date 2018/4/24
 */
@Service
public class PermissionService {
    public Set<Permission> selectByUser(User user) {
        return null;
    }
}
