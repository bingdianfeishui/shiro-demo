package top.youngcoding.shiro02.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.youngcoding.shiro02.entity.User;
import top.youngcoding.shiro02.service.PermsService;
import top.youngcoding.shiro02.service.UserService;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author liy
 * @date 2018/4/17
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private PermsService permsService;

    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(userService.selectRolesByUsername(user.getUsername()));
        authorizationInfo.addStringPermissions(permsService.selectPermsByUsername(user.getUsername()));
        this.setRolePermissionResolver(new RolePermissionResolver() {
            @Override
            public Collection<Permission> resolvePermissionsInRole(String roleString) {
                return Arrays.asList(new WildcardPermission("OrderAdd"));
            }
        });
        return authorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = (String) userToken.getPrincipal();
        User user = userService.selectByUsername(username);
        if (user != null) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
            return authenticationInfo;
        }
        return null;
    }
}
