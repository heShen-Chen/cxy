package lctvu.dao;

import lctvu.bean.News;
import lctvu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class NewsDao {
    QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
    /**
     * 删除id在数组arr中的元素。
     * @param arr
     * @return
     * @throws SQLException
     */
    public boolean deleteArticlesByArray(String[] arr) throws SQLException {
        String str="";
        for(int i=0;i<arr.length;i++){
            str=str+arr[i]+",";
        }
        str=str.substring(0,str.length()-1);//去掉最后一个逗号
        String sql="delete from news where id in ("+str+")";
        System.out.println(str);
        int n=queryRunner.update(sql);
        if(n>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据id查询某个新闻
     * @param id
     * @return
     * @throws SQLException
     */
    public News getNewsById(int id) throws SQLException {
        String sql="select * from news where id=? ";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql,new BeanHandler<News>(News.class),id);
    }

    /**
     * 添加新闻
     * @param news
     * @return
     * @throws SQLException
     */
    public Boolean addNews(News news) throws SQLException {
        String sql="insert into news(title,content,tdate,itemid) values(?,?,?,?)";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        int n= queryRunner.update(sql,news.getTitle(),news.getContent(),news.getTdate(),news.getItemid());
        if(n>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 修改新闻
     * @param
     * @return
     * @throws SQLException
     */
    public Boolean updateNews(News news) throws SQLException {
        String sql="update news set title=?,content=?,tdate=?,itemid=? where id=?";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        int n=queryRunner.update(sql,news.getTitle(),news.getContent(),news.getTdate(),news.getItemid(),news.getId());
        if(n>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据id删除新闻
     * @param id
     * @return
     * @throws SQLException
     */
    public Boolean deleteNews(int id) throws SQLException {
        String sql="delete from news where id=?";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        int n=queryRunner.update(sql,id);
        if(n>0){
            return true;
        }else {
            return false;
        }
    }
}
