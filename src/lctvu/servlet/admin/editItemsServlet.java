package lctvu.servlet.admin;

import lctvu.bean.Items;
import lctvu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/editItemsServlet")
public class editItemsServlet extends HttpServlet {
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String strid=request.getParameter("id");
        int id=0;
        if(strid != null){
            id=Integer.parseInt(strid);
        }
        Items items= itemService.getItemById(id);
        request.setAttribute("item",items);

        request.getRequestDispatcher("/admin/categoryedit.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
