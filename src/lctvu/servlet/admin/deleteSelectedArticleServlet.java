package lctvu.servlet.admin;

import lctvu.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/deleteSelectedArticleServlet")
public class deleteSelectedArticleServlet extends HttpServlet {
    private NewsService newsService=new NewsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String[] itemids=request.getParameterValues("checkbox[]");
        boolean b= newsService.deleteArticlesByArray(itemids);
        if(b){
            out.print("<script language='javascript'>alert('删除成功'); document.location.href='/admin/ArticleServlet'</script>");
        }else {
            out.print("<script language='javascript'>alert('删除失败'); document.location.href='/admin/ArticleServlet'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request,response);
    }
}