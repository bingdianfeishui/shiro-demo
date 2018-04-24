package top.youngcoding.shiro.demo.ch03.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author liy
 * @date 2018/4/23
 */
@Data
public class Role {
    private Integer id;
    private String name;
    private String type;
    private Set<Permission> permissions;
}
