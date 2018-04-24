package top.youngcoding.shiro.demo.ch03.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.youngcoding.shiro.demo.ch03.config.MybatisConfig;
import top.youngcoding.shiro.demo.ch03.entity.Permission;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liy
 * @date 2018/4/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class PermissionMapperTest {

    @Resource
    PermissionMapper permissionMapper;

    @Test
    public void getAllPerms() {
        List<Permission> perms = permissionMapper.getAllPerms();
        perms.forEach(p-> System.out.println(p));
        assertEquals(26, perms.size());
    }
}