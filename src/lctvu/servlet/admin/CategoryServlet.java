package lctvu.servlet.admin;

import lctvu.bean.Items;
import lctvu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Items> list=itemService.getAllItems();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/category.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
