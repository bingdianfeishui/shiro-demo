package top.youngcoding.shiro.demo.ch03.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author liy
 * @date 2018/4/23
 */
@Data
public class User {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String salt;
    private Integer status;
//    private Set<Role> roles;
//    private Set<Permission> permissions;
}
