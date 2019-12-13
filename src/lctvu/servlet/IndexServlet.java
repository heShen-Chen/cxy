package lctvu.servlet;

import lctvu.bean.ItemNews;
import lctvu.service.ItemNewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private ItemNewsService itemNewsService=new ItemNewsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemNews> listxwdt=itemNewsService.getNewsByItemTop(1);
        List<ItemNews> listsszx=itemNewsService.getNewsByItemTop(2);
        List<ItemNews> listkszx=itemNewsService.getNewsByItemTop(3);
        List<ItemNews> listxfgcs1=itemNewsService.getNewsByItemTop(4);
        List<ItemNews> listxfgcs2=itemNewsService.getNewsByItemTop(5);
        request.setAttribute("listxwdt",listxwdt);
        request.setAttribute("listsszx",listsszx);
        request.setAttribute("listkszx",listkszx);
        request.setAttribute("listxfgcs1",listxfgcs1);
        request.setAttribute("listxfgcs2",listxfgcs2);
        request.getRequestDispatcher("/myindex.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
