package org.itstep.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class servletFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String uri = req.getRequestURI();
        boolean b = (uri.compareTo("/") == 0)||(uri.compareTo("/login") == 0) || (uri.compareTo("/css/login.css") == 0);
        if(!b) {
            boolean marker = Boolean.valueOf((String) req.getSession().getAttribute("auth"));
            if (!marker) {
                resp.sendRedirect("/");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
