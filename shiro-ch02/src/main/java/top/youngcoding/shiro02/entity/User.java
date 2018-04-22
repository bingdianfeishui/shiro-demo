package top.youngcoding.shiro02.entity;

import lombok.Data;

/**
 * @author liy
 * @date 2018/4/20
 */
@Data
public class User {
    private String username;
    private String password;
    private String salt;
}
