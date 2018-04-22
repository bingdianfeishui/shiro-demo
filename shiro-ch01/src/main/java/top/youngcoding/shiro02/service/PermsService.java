package top.youngcoding.shiro02.service;

import org.springframework.stereotype.Service;
import top.youngcoding.shiro02.entity.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liy
 * @date 2018/4/17
 */
@Service
public class PermsService {
    enum PERMS {
        ItemAdd, ItemList, ItemUpdate, ItemDelete, OrderAdd, OrderDelete, OrderUpdate, OrderSubmit;

    }

    static Set<String> adminPerms = new HashSet<>();
    static Set<String> userPerms = new HashSet<>();
    static Set<String> guestPerms = new HashSet<>();

    static {
        adminPerms.addAll(Stream.of(PERMS.values()).map(p->p.name()).collect(Collectors.toSet()));
        userPerms.addAll(Arrays.asList(PERMS.ItemList.name(), PERMS.OrderAdd.name(), PERMS.OrderUpdate.name(), PERMS.OrderSubmit.name(), PERMS.OrderDelete.name()));
        guestPerms.addAll(Arrays.asList(PERMS.ItemList.name()));
    }

    public Set<String> selectPermsByUsername(String username) {
        switch (username.toLowerCase()) {
            case "admin":
                return adminPerms;
            case "user":
                return userPerms;
            case "guest":
                return guestPerms;
            default:
                return Collections.emptySet();
        }
    }
}
