package lctvu.servlet.admin;

import lctvu.bean.Items;
import lctvu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/editItemsSubmitServlet")
public class editItemsSubmitServlet extends HttpServlet {
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //设置请求编码为utf-8,在tomcat8以下用
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        String itemname=request.getParameter("itemname");
        Items items=new Items();
        items.setId(id);
        items.setItemname(itemname);
        boolean b=itemService.updateItems(items);
        if(b){
            out.print("<script language='javascript'>alert('修改成功');document.location.href='/admin/CategoryServlet'</script>");
        }else {
            out.print("<script language='javascript'>alert('修改失败');document.location.href='/admin/CategoryServlet'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
