package top.youngcoding.shiro02;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;

/**
 * @author liy
 * @date 2018/4/20
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("+++++++++++++++principals+++++++++++++++++");
        System.out.println(principals.asList());
        System.out.println(principals.getPrimaryPrincipal());
        SimpleAuthorizationInfo authzInfo = new SimpleAuthorizationInfo();
        authzInfo.addStringPermissions(new HashSet<String>(){
            {
                add("order:delete");
            }
        });
        return authzInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("+++++++++++++++token+++++++++++++++++");
        System.out.println((UsernamePasswordToken)token);
        SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo("admin","01881fcb1421675215ec5c9900e06f56c8fa2d860e991dd0b39404699623edf29cdf84ae5189a3af5f7c32176398d26d", ByteSource.Util.bytes("123"),getName());
        return authcInfo;
    }
}
