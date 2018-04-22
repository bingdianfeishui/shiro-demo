package top.youngcoding.shiro02.service;

import org.springframework.stereotype.Service;
import top.youngcoding.shiro02.entity.User;

import java.util.*;

/**
 * @author liy
 * @date 2018/4/17
 */
@Service
public class UserService {
    private static Map<String, User> userDao = new HashMap<>();
    private static Map<String, Set<String>> roles = new HashMap<>();


    static {
        userDao.put("admin", new User("admin", "123", "salt"));
        userDao.put("user", new User("user", "123", "salt"));
        userDao.put("guest", new User("guest", "123", "salt"));
        userDao.put("tom", new User("tom", "123", "salt"));


        Set<String> adminRoles = new HashSet<>();
        Set<String> userRoles = new HashSet<>();
        Set<String> guestRoles = new HashSet<>();

        adminRoles.addAll(Arrays.asList("admin", "order"));
        userRoles.addAll(Arrays.asList("user", "cust"));
        guestRoles.addAll(Arrays.asList("guest"));

        roles.put("admin", adminRoles);
        roles.put("user", userRoles);
        roles.put("guest", guestRoles);
    }

    public User selectByUsername(String username) {
        return userDao.get(username);
    }

    public Set<String> selectRolesByUsername(String username) {
        return roles.get(username);
    }
}
