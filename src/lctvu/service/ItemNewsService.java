package lctvu.service;

import lctvu.bean.ItemNews;
import lctvu.bean.PageBean;
import lctvu.dao.ItemNewsDao;

import java.sql.SQLException;
import java.util.List;

public class ItemNewsService {
    private ItemNewsDao itemNewsDao=new ItemNewsDao();

    /**
     * 取得每一页的数据
     * @param pageNum：页码（第几页）
     * @param pageSize：每页几条记录
     * @param stritemid：栏目id
     * @param title:查询的标题内容
     * @return
     */
    public PageBean<ItemNews> getNewsWithPage(int pageNum, int pageSize, String  stritemid, String title){
        //在这里我们将PageBean中的数据创建好，再通过方法返回
        try {
            //得到items栏目下的所有数据
//            List<News> allNews=newsDao.getNewsByItem(items);
            //得到记录数
            int totalRecord=itemNewsDao.getTotalRecords(stritemid,title);
            //有了3个初始数据，构造PageBean对象
            PageBean<ItemNews> pb=new PageBean<>(pageNum,pageSize,totalRecord);
            //得到起始索引
            int startIndex= pb.getStartIndex();
            //有startIndex和pageSize就可以拿到每页的数据了
            List<ItemNews> pageNews=itemNewsDao.getNewsPage(startIndex,pageSize,stritemid,title);
            //把每页数据放在pb的list中
            pb.setList(pageNews);
            return pb;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    //得到所有新闻
    public List<ItemNews> getAllNews(){
        try {
            return itemNewsDao.getAllNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //得到某个栏目下的所有新闻
    public List<ItemNews> getNewsByItem(int itemid){
        try {
            return itemNewsDao.getNewsByItemId(itemid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询某个栏目下的前6条文章
    public List<ItemNews> getNewsByItemTop(int itemid){
        try {
            return   itemNewsDao.getNewsByItemTop(itemid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //根据id查询某个文章
    public ItemNews getNewsById(int id){
        try {
            return itemNewsDao.getNewsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
