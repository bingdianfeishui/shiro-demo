package top.youngcoding.shiro.demo.ch03.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import top.youngcoding.shiro.demo.ch03.config.MybatisConfig;
import top.youngcoding.shiro.demo.ch03.config.RootConfig;
import top.youngcoding.shiro.demo.ch03.config.WebAppInitializer;
import top.youngcoding.shiro.demo.ch03.entity.Role;
import top.youngcoding.shiro.demo.ch03.entity.User;

import javax.annotation.Resource;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liy
 * @date 2018/4/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectById() {
        Long id = 999l;
        User user = userMapper.selectById(id);
        assertNotNull(user);
        assertEquals(id, user.getId());
    }

    @Test
    public void selctByUsername() {
        String username = "admin";
        User user = userMapper.selectByUsername(username);
        assertNotNull(user);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void update() {
        Long id = 999L;
        User user = userMapper.selectById(id);
        user.setStatus(2);
        int ret = userMapper.update(user);
        assertEquals(1, ret);
        User user2 = userMapper.selectById(id);
        assertEquals(Integer.valueOf(2), user2.getStatus());
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void selectRoles() {
        Long uid = 1001l;
        List<Role> roleList = userMapper.selectRoles(uid);
        System.out.println(roleList);
        assertNotNull(roleList);
        assertFalse(roleList.isEmpty());
        assertEquals(3, roleList.size());
    }

    @Test
    public void changeRole() {
        Long uid = 1l;
        Integer rid = 1;
        int ret1 = userMapper.addRole(uid, rid);
        assertEquals(1, ret1);
        int ret2 = userMapper.addRole(uid, rid + 1);
        assertEquals(1, ret2);
        int ret3 = userMapper.deleteRole(uid, rid);
        assertEquals(1, ret3);
        int ret4 = userMapper.clearRolesByUserId(uid);
        assertEquals(1, ret4);
    }

}
