package top.youngcoding.shiro.demo.ch03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.youngcoding.shiro.demo.ch03.dao.PermissionMapper;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
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
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleService roleService;

    public List<Permission> selectByUser(User user) {
        List<Role> roles = roleService.selectByUser(user);
        return permissionMapper.getPermsByRoles(roles);
    }

    public List<Permission> getAllPerms() {
        return permissionMapper.getAllPerms();
    }
}
