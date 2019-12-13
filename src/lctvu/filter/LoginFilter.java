package lctvu.filter;

import lctvu.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request=(HttpServletRequest) req;
        HttpSession session=request.getSession();
        if(request.getServletPath().contains("login.jsp") || request.getServletPath().contains("LoginServlet") || request.getServletPath().endsWith(".css")
                || request.getServletPath().contains(".jpg")|| request.getServletPath().endsWith(".js")){
            chain.doFilter(req,resp);

        }else {
            User user=(User)session.getAttribute("user");
            if(user==null){
                PrintWriter out=resp.getWriter();
                out.println("<script language='javascript'>alert('没有权限登录，请登录'); document.location.href='login.jsp';</script>");
                out.flush();
                out.close();
            }else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}