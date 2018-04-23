package top.youngcoding.shiro.demo.ch03.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author liy
 * @date 2018/4/23
 */
@Data
public class Resource {
    private Integer id;
    private String name;
    private String type;
}
