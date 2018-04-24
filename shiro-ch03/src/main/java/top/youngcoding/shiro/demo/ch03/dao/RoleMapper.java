package top.youngcoding.shiro.demo.ch03.dao;

import org.apache.ibatis.annotations.Insert;
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
public interface RoleMapper {

    @Insert("insert into u_role(name,type) value(#{name},#{type})")
    int insert(Role role);

    @Select("select rp.pid as id, p.name, p.desc from u_role_permission as rp left join u_permission as p on rp.pid=p.id where rp.rid=#{rid}")
    List<Permission> getPermissionsByRoleId(Integer rid);

    @Select("<script>select rp.pid as id, p.name, p.desc from u_role_permission as rp left join u_permission as p on rp.pid=p.id where rp.rid in " +
            "<foreach collection='roles' open='(' close=')' " +
            "        item='role' separator=','> " +
            "            #{role.id} " +
            "        </foreach></script>")
    List<Permission> getPermissionsByRoles(@Param("roles") Collection<Role> roles);
}
