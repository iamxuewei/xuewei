package com.xuewei.interceptor;

import com.xuewei.vo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * 登录验证拦截器
 */
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    //下面的地址跳过拦截器
    protected static Set<String> statsdUrls = new HashSet<String>();
    static {
        statsdUrls.add("/login/validateUser/");
        statsdUrls.add("/login/authentication");
    }

    /**
     * 优先所有方法执行前的方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (handler instanceof HandlerMethod) {
                    String reqUrl = request.getServletPath();
                    if (statsdUrls.contains(reqUrl)) {
                        return true;
                    } else{
                        //获取用户登录信息
                        User user = (User) request.getSession().getAttribute("user");
                        if (user != null) {
                            return true;
                        }
                        //跳转到登录页面
                        response.sendRedirect("/login/authentication");
                    }
                }
                return true;
            }

        });


    }
}