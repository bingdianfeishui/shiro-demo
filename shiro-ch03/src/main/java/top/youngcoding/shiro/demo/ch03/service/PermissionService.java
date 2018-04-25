package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.dao.PermissionMapper;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
import top.youngcoding.shiro.demo.ch03.entity.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author liy
 * @date 2018/4/24
 */
@Service
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    public List<Permission> selectByUser(User user) {
        return null;
    }

    public List<Permission> getAllPerms() {
        return permissionMapper.getAllPerms();
    }
}
