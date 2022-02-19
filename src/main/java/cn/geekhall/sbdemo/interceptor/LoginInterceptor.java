package cn.geekhall.sbdemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginInterceptor
 * 登录检查
 * 1. 配置好拦截器要拦截哪些请求
 * 2. 把这些配置放在容器中
 *
 * @author yiny
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
//        System.out.println("=================== preHandle ===================");
//        System.out.println(requestURI);
//        System.out.println("=================== preHandle ===================");
        // 登录检查逻辑
        HttpSession session = request.getSession();
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            // 放行
//            return true;
//        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }
}
