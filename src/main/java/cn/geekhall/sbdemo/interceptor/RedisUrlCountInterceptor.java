package cn.geekhall.sbdemo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RedisUrlCountInterceptor
 *
 * @author yiny
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("=================== RedisUrlCountInterceptor.preHandle ===================");
        System.out.println(uri);
        System.out.println("=================== RedisUrlCountInterceptor.preHandle ===================");

        // 页面访问计数器，默认每次访问当前uri就会计数 +1
        redisTemplate.opsForValue().increment(uri);
        String s = redisTemplate.opsForValue().get(uri);
        System.out.println(s);
        return true;
    }
}
