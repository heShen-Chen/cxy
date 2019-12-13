package lctvu.servlet.admin;

import lctvu.bean.News;
import lctvu.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/admin/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    private NewsService newsService=new NewsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String title=request.getParameter("title");
        System.out.println(request.getParameter("itemid"));
        int itemid=Integer.parseInt(request.getParameter("itemid"));
        String content=request.getParameter("content");
        Date tdate=new Date();
        News news=new News();
        news.setTitle(title);
        news.setItemid(itemid);
        news.setContent(content);
        news.setTdate(tdate);
        boolean b=newsService.addNews(news);
        if(b){
            out.println("<script language='javascript'>alert('添加成功'); document.location.href='ArticleServlet';</script>");
        }else {
            out.println("<script language='javascript'>alert('添加失败'); document.location.href='ArticleServlet';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
