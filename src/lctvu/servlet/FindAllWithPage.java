package lctvu.servlet;

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

@WebServlet("/FindAllWithPage")
public class FindAllWithPage extends HttpServlet {
    //Servlet层调用Service层的ItemNewsService
    private ItemNewsService itemNewsService=new ItemNewsService();
    // 调用 ItemService
    private ItemService itemService=new ItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //得到当前页码
        int pageNum;
        if(request.getParameter("pageNum")==null ||Integer.parseInt(request.getParameter("pageNum"))<1){
            pageNum=1;
        }else {
            pageNum=Integer.parseInt(request.getParameter("pageNum"));
        }
        //获得当前栏目id
        String stritemid=request.getParameter("itemid");
        //要查询的标题为空，就是任何标题都可以查出来。这里不按标题进行查询
        String title="";
        PageBean<ItemNews> pageBean=itemNewsService.getNewsWithPage(pageNum,3,stritemid,title);
        //将分页数据放在request域中
        request.setAttribute("pageBean",pageBean);
        //得到当前显示的栏目对象，并存放在request域中
        if(stritemid!=null){
            int itemid=Integer.parseInt(stritemid);
            Items items=itemService.getItemById(itemid);
            request.setAttribute("items",items);
        }
        //得到所有栏目
        List<Items> itemlist= itemService.getAllItems();
        request.setAttribute("itemlist",itemlist);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
