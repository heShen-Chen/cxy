package lctvu.service;

import lctvu.bean.News;
import lctvu.dao.NewsDao;

import java.sql.SQLException;

public class NewsService {
    //创建NewsDao对象，调用dao层方法
    private NewsDao newsDao=new NewsDao();
    public boolean deleteArticlesByArray(String[] arr){
        try {
            return newsDao.deleteArticlesByArray(arr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //根据id查询某个文章
    public News getNewsById(int id){
        try {
            return newsDao.getNewsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //添加文章
    public Boolean addNews(News news){
        try {
            return   newsDao.addNews(news);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //修改文章
    public Boolean updateNews(News news){
        try {
            return   newsDao.updateNews(news);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //删除文章
    public Boolean deleteNews(int id){
        try {
            return newsDao.deleteNews(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
