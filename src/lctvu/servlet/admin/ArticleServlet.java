package lctvu.servlet.admin;

import lctvu.bean.ItemNews;
import lctvu.bean.Items;
import lctvu.bean.PageBean;
import lctvu.service.ItemNewsService;
import lctvu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    private ItemNewsService itemNewsService=new ItemNewsService();
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //得到当前页码
        int pageNum;
        if (request.getParameter("pageNum")==null||Integer.parseInt(request.getParameter("pageNum"))<1){
            pageNum=1;
        }else{
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        //获取要查询的栏目id
        String stritemid=request.getParameter("itemid");
        if (stritemid==null){
            stritemid="all";
        }
        //获得要查询的标题
        String title=request.getParameter("title");
        if (title==null){
            title="";
        }
        request.setAttribute("title",title);
        PageBean<ItemNews> pageBean=itemNewsService.getNewsWithPage(pageNum,2,stritemid,title);
        //查询出所有的栏目
        List<Items> listitems=itemService.getAllItems();
        request.setAttribute("listitems",listitems);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("itemid",stritemid);
        request.setAttribute("title",title);
        request.getRequestDispatcher("/admin/article.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
