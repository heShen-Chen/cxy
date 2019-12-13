package lctvu.servlet.admin;

import lctvu.bean.User;
import lctvu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/admin/AddManagerServlet")
public class AddManagerServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String repassword=request.getParameter("password_confirm");
        String email=request.getParameter("email");
        if(!password.equals(repassword)){
            out.print("<script language='javascript'>alert('密码和确认密码不一致，重新添加');document.location.href='/admin/manageradd.jsp';</script>");
            return;
        }
        User user =new User(username,password,email,new Date());
        boolean b= userService.addUser(user);
        if(b){
            out.print("<script language='javascript'>alert('用户添加成功');document.location.href='AdminServlet';</script>");
        }else{
            out.print("<script language='javascript'>alert('用户添加失败');document.location.href='AdminServlet';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
