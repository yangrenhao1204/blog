package top.yangrenhao.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String method = request.getMethod().toLowerCase();
        if (request.getSession().getAttribute("user") == null
            && "post".equals(method)){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
