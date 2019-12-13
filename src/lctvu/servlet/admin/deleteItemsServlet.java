package lctvu.servlet.admin;

import lctvu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/deleteItemsServlet")
public class deleteItemsServlet extends HttpServlet {
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String  strid =request.getParameter("id");
        int id=0;
        if(strid!=null){
            id=Integer.parseInt(strid);
        }
        boolean b=itemService.deleteItems(id);
        if(b){
            out.print("<script language='javascript'>alert('删除成功');document.location.href='/admin/CategoryServlet'</script>");
        }else {
            out.print("<script language='javascript'>alert('删除失败');document.location.href='/admin/CategoryServlet'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
