package lctvu.servlet.admin;

import lctvu.bean.Items;
import lctvu.bean.News;
import lctvu.service.ItemService;
import lctvu.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
    private NewsService newsService=new NewsService();
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        News news=newsService.getNewsById(id);
        request.setAttribute("article",news);
        //查询出所有的栏目
        List<Items> listitems=itemService.getAllItems();
        request.setAttribute("listitems",listitems);
        request.getRequestDispatcher("/admin/articleedit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
