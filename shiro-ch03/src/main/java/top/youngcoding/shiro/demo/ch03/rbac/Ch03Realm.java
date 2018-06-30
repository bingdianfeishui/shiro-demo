package top.youngcoding.shiro.demo.ch03.rbac;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import top.youngcoding.shiro.demo.ch03.entity.Permission;
import top.youngcoding.shiro.demo.ch03.entity.Role;
import top.youngcoding.shiro.demo.ch03.entity.User;
import top.youngcoding.shiro.demo.ch03.service.PermissionService;
import top.youngcoding.shiro.demo.ch03.service.RoleService;
import top.youngcoding.shiro.demo.ch03.service.UserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liy
 * @date 2018/4/20
 */
public class Ch03Realm extends AuthorizingRealm {
    @Resource
    @Lazy
    private UserService userService;
    @Resource
    @Lazy
    private PermissionService permissionService;
    @Resource
    @Lazy
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("+++++++++++++++ principals +++++++++++++++++");
        System.out.println(principals.asList());
        String username;
        System.out.println((username = (String) principals.getPrimaryPrincipal()));

        List<Permission> perms;
        if ("admin".equals(username)) {
            System.out.println("admin用户，拥有全部权限许可！！");
            perms = permissionService.getAllPerms();
        } else {
            User user = userService.selectByUsername(username);
            List<Role> roles = roleService.selectByUser(user);
            perms = permissionService.selectByUser(user);
            //roles.forEach(r -> perms.addAll(r.getPermissions()));
        }
        SimpleAuthorizationInfo authzInfo = new SimpleAuthorizationInfo();
        authzInfo.addStringPermissions(perms.stream().map(p -> p.getName()).collect(Collectors.toSet()));
        return authzInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        System.out.println("+++++++++++++++ token +++++++++++++++++");
        System.out.println((UsernamePasswordToken) token);
        User user = userService.selectByUsername(upt.getUsername());
        if (user == null)
            throw new UnknownAccountException("用户名或密码错误");

        String salt = user.getSalt();
        SimpleAuthenticationInfo authcInfo = salt == null ?
                new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName())
                : new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(salt), getName());

        return authcInfo;
    }
}
