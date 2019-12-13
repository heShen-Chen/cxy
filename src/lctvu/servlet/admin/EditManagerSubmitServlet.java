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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/EditManagerSubmitServlet")
public class EditManagerSubmitServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String repassword=request.getParameter("password_confirm");
        if(!password.equals(repassword)){
            out.print("<script language='javascript'>alert('密码和确认密码不一致'); window.history.go(-1);</script>");
            return;
        }

        String mydate=request.getParameter("tdate");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tdate=simpleDateFormat.parse(mydate);
            User user=new User(id,username,password,email,tdate);
            boolean b=userService.updateUser(user);
            if(b){
                out.print("<script language='javascript'>alert('用户修改成功'); document.location.href='/admin/AdminServlet';</script>");
            }else {
                out.print("<script language='javascript'>alert('用户修改失败'); document.location.href='/admin/AdminServlet';</script>");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
