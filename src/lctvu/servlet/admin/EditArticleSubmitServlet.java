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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/EditArticleSubmitServlet")
public class EditArticleSubmitServlet extends HttpServlet {
    private NewsService newsService=new NewsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        //
        System.out.println("id:");
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String title=request.getParameter("title");
        int itemid=Integer.parseInt(request.getParameter("itemid"));
        String content=request.getParameter("content");
        String strdate=request.getParameter("tdate");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tdate=format.parse(strdate);
            News news=new News();
            news.setId(id);
            news.setTitle(title);
            news.setItemid(itemid);
            news.setTdate(tdate);
            news.setContent(content);
            boolean b= newsService.updateNews(news);
            if(b){
                out.print("<script language='javascript'>alert('修改成功'); document.location.href='/admin/ArticleServlet'</script>");
            }else {
                out.print("<script language='javascript'>alert('修改失败'); document.location.href='/admin/ArticleServlet'</script>");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
