package top.youngcoding.shiro.demo.ch03.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

/**
 * @author liy
 * @date 2018/4/23
 */
@Data
public class Permission {
    private Integer id;
    private String name;
    private String desc;
//    private Resource resource;
}
