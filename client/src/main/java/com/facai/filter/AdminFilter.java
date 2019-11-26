package com.facai.filter;

import com.facai.entity.Admin;
import com.facai.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
@WebFilter(urlPatterns = {"/main.html"},filterName = "adminFilter")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        Admin admin= (Admin) session.getAttribute("admin");
        if(admin!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        response.sendRedirect("login.html");
    }

    @Override
    public void destroy() {

    }
}
