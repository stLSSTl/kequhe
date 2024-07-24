package com.science.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.science.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String token=request.getHeader("Authorization");
        String requestUsername = request.getHeader("X-Username"); // 从自定义请求头中获取用户名
        if(token==null|| token.isEmpty() || !token.startsWith("Bearer ")){
            //此处如果需要跳转到某个页面可以使用:response.sendRedirect("/web/login.html");
            return false;
        }
        token = token.substring(7);
        DecodedJWT decodedJWT=jwtUtil.verifyToken(token);
        if(decodedJWT == null){
            //此处如果需要跳转到某个页面可以使用:response.sendRedirect("/web/login.html");
            return false;
        }
        String tokenUsername=decodedJWT.getSubject();
        if(requestUsername == null || !requestUsername.equals(tokenUsername)){
            return false;
        }

        return true;
    }
}
/**使用该拦截器需要前端在请求头中设置当前请求用户名
 headers: {
 'Authorization': `Bearer ${token}`,
 'X-Username': username // 自定义请求头传递用户名
 }*/