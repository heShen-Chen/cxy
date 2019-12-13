package lctvu.servlet.admin;

import lctvu.bean.User;
import lctvu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out =response.getWriter();
        String username=request.getParameter("username");
        String password =request.getParameter("password");
        User user= userService.getUserByNameAndPass(username,password);
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/admin/index.jsp").forward(request,response);
            return;
        }else {
            out.println("<script language='javascript'>alert('用户名或者密码不对，请重新输入！'); document.location.href='/admin/login.jsp';</script>");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
