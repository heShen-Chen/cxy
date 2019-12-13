package lctvu.servlet.admin;

import lctvu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/deleteAdminServlet")
public class deleteAdminServlet extends HttpServlet {
        private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        boolean b=userService.deleteUser(id);
        if(b){
            out.print("<script language='javascript'>alert('用户删除成功'); document.location.href='/admin/AdminServlet';</script>");
        }else {
            out.print("<script language='javascript'>alert('用户删除失败'); document.location.href='/admin/AdminServlet';</script>");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
