package top.youngcoding.shiro.demo.ch03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
import top.youngcoding.shiro.demo.ch03.entity.Role;

import java.util.Collection;
import java.util.List;

/**
 * @author liy
 * @date 2018/4/24
 */
@Mapper
public interface PermissionMapper {
    @Select("select * from u_permission")
    List<Permission> getAllPerms();

    @Select("<script>select p.id, p.name, p.desc from u_permission p left join u_role_permission r_p on p.id=r_p.pid where r_p.rid in "+
            "<foreach collection='roles' open='(' close=')' " +
            "        item='role' separator=','> " +
            "            #{role.id} " +
            "        </foreach></script>")
    List<Permission> getPermsByRoles(@Param("roles") Collection<Role> roles);
}
