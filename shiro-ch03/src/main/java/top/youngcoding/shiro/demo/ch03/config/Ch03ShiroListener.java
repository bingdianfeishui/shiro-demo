package top.youngcoding.shiro.demo.ch03.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author liy
 * @date 2018/4/25
 */
public class Ch03ShiroListener implements AuthenticationListener {
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {

    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {

    }

    @Override
    public void onLogout(PrincipalCollection principals) {

    }
}
