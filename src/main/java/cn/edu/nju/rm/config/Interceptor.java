package cn.edu.nju.rm.config;

import cn.edu.nju.rm.model.Account;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 获取请求的url
        String url = request.getRequestURI();

        // 放行链接
        if (check(url)) {
            return true;
        }

        // 判断session
        HttpSession session = request.getSession();
        // 从session中取出用户身份信息
        Account account = (Account) session.getAttribute("account");
        // 执行这里表示用户身份需要认证，跳转登陆页面
        request.getRequestDispatcher("/login").forward(request, response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    private boolean check(String url){
        return (url.contains("home")
                || url.contains("login")
                || url.contains("register")
                || ( url.contains("post/") && !url.contains("send") )
        );
    }

}
