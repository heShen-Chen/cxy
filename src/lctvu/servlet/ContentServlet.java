package lctvu.servlet;

import lctvu.bean.ItemNews;
import lctvu.service.ItemNewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {
    private ItemNewsService itemNewsService=new ItemNewsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.valueOf(request.getParameter("id"));
        ItemNews itemNews=itemNewsService.getNewsById(id);
        request.setAttribute("itemNews",itemNews);
        request.getRequestDispatcher("/content.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
