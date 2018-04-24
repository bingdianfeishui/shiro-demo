package top.youngcoding.shiro.demo.ch03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.youngcoding.shiro.demo.ch03.entity.Permission;

import java.util.List;

/**
 * @author liy
 * @date 2018/4/24
 */
@Mapper
public interface PermissionMapper {
    @Select("select * from u_permission")
    List<Permission> getAllPerms();
}
