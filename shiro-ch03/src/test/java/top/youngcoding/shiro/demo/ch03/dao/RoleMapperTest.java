package top.youngcoding.shiro.demo.ch03.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.youngcoding.shiro.demo.ch03.config.MybatisConfig;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
import top.youngcoding.shiro.demo.ch03.entity.Role;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liy
 * @date 2018/4/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class RoleMapperTest {

    @Resource
    RoleMapper roleMapper;

    @Test
    public void insert() {
    }

    @Test
    public void getPermissionsByRoleId() {
        Integer roleId = 4;
        List<Permission> perms = roleMapper.getPermissionsByRoleId(roleId);
        perms.forEach(p-> System.out.println(p.getName()));
    }
    @Test
    public void getPermissionsByRoles() {
        List<Role> roles = new ArrayList<Role>(){{
            Role r1 = new Role(), r2 = new Role();
            r1.setId(2);
            r2.setId(6);
            add(r1);
            add(r2);
        }};
        List<Permission> perms = roleMapper.getPermissionsByRoles(roles);
        perms.forEach(p-> System.out.println(p.getName()));
        assertEquals(10, perms.size());
    }
}
