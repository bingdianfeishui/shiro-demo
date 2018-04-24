package top.youngcoding.shiro.demo.ch03.dao;

import org.apache.ibatis.annotations.*;
import top.youngcoding.shiro.demo.ch03.entity.Role;
import top.youngcoding.shiro.demo.ch03.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author liy
 * @date 2018/4/24
 */
@Mapper
public interface UserMapper {

    @Select("select * from u_user where id=#{id}")
    User selectById(Serializable id);

    @Select("select * from u_user where username=#{username}")
    User selectByUsername(String username);

    @Update("update u_user set username=#{username}, password=#{password},status=#{status} where id=#{id}")
    int update(User user);

    @Delete("delete from u_user where id=#{id}")
    int deleteById(Serializable id);

    @Select("select ur.rid as id, r.name, r.type from u_user_role as ur left join u_role as r on ur.rid= r.id where ur.uid=#{id}")
    List<Role> selectRoles(Serializable uid);

    @Delete("delete from u_user_role where uid=#{userId}")
    int clearRolesByUserId(Serializable userId);

    @Insert("insert into u_user_role(uid, rid) values(#{uid},#{rid})")
    int addRole(@Param("uid") Serializable userId, @Param("rid") Integer roleId);

    @Delete("delete from u_user_role where uid=#{uid} and rid=#{rid}")
    int deleteRole(@Param("uid") Serializable userId, @Param("rid") Integer roleId);

}
