package top.youngcoding.shiro.demo.ch02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author liy
 * @date 2018/4/22
 */
public class RetryExceptionListener implements AuthenticationListener {
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {

    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        if (ae instanceof ExcessiveAttemptsException) {
            Subject subject = SecurityUtils.getSubject();
            System.out.println(subject.getPrincipal());
            System.out.println(ae.getMessage());
            // ...do smt.
        }
    }

    @Override
    public void onLogout(PrincipalCollection principals) {

    }
}
