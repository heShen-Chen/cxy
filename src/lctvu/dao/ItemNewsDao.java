package lctvu.dao;

import lctvu.bean.ItemNews;
import lctvu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ItemNewsDao {
    /**
     * 根据文章栏目和文章标题查询文章记录数
     * @param stritemid：文章栏目 ，如果为null,则查询所有栏目
     * @param title :查询标题，如果为"",则查询所有
     * @return
     * @throws SQLException
     */
    public int getTotalRecords(String stritemid,String title) throws SQLException {
        String sql="";
        //查询的记录数默认为0
        Long totalRecords=0l;
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        //如果stritemid为all，则查询所有栏目记录
        if(stritemid.equals("all")){
            sql="select count(*) totalRecords from item_news where  title like '%"+title+"%'";
            //得到某个栏目 下的记录数
            totalRecords=(Long) queryRunner.query(sql,new ScalarHandler("totalRecords"));
        }else {
            int itemid=Integer.parseInt(stritemid);
            sql="select count(*) totalRecords from item_news where itemid=? and title like '%"+title+"%'";
            totalRecords=(Long) queryRunner.query(sql,new ScalarHandler("totalRecords"),itemid);
        }

        //先把long类型转成Number类型，Number类型是Integer,Long的父类.
        Number number=(Number) totalRecords;
        //把Number类型转成int类型
        int totalRecords2=number.intValue();
        return totalRecords2;
    }

    /**
     *查询标题为title,栏目id为stritemid的从start开始的,每一页为pageSize条记录，主要用于分页查询
     * @param start
     * @param pageSize
     * @param title
     * @return
     * @throws SQLException
     */
    public List<ItemNews> getNewsPage(int start, int pageSize, String stritemid, String title) throws SQLException {
        String sql="";
        //如果 stritemid为all，则查询所有栏目内容
        if(stritemid.equals("all")){
            //limit与ordery混用时，如果排序字段有数据重复的情况下，会很容易出现排序结果与预期不一致的问题
            //所以排序时我又加了一个id，因为id是唯一的，这样的排序不会存在重复
            sql="select * from item_news where  title like '%"+title+"%' order by tdate desc,id desc limit ?,?";
            QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
            return queryRunner.query(sql,new BeanListHandler<ItemNews>(ItemNews.class),start,pageSize);
        }else {
            int itemid=Integer.parseInt(stritemid);
            //limit与ordery混用时，如果排序字段有数据重复的情况下，会很容易出现排序结果与预期不一致的问题
            //所以排序时我又加了一个id，因为id是唯一的，这样的排序不会存在重复
            sql="select * from item_news where itemid=? and  title like '%"+title+"%' order by tdate,id desc limit ?,?";
            QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
            return queryRunner.query(sql,new BeanListHandler<ItemNews>(ItemNews.class),itemid,start,pageSize);
        }

    }

    /**
     * 查询所有新闻
     * @return
     * @throws SQLException
     */
    public List<ItemNews> getAllNews() throws SQLException {
        String sql="select * from item_news order by tdate desc";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<ItemNews>(ItemNews.class));
    }

    /**
     * 查询某个栏目下的所有新闻
     * @param itemid
     * @return
     * @throws SQLException
     */
    public List<ItemNews> getNewsByItemId(int itemid) throws SQLException {
        String sql="select * from item_news where itemid=? order by tdate desc";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<ItemNews>(ItemNews.class),itemid);
    }

    /**
     * 查询某个栏目下的前6条新闻
     * @param itemid
     * @return
     * @throws SQLException
     */
    public List<ItemNews> getNewsByItemTop(int itemid) throws SQLException {
        String sql="select * from item_news where itemid=? order by tdate desc limit 0,6";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<ItemNews>(ItemNews.class),itemid);
    }

    /**
     * 根据id查询某个新闻
     * @param id
     * @return
     * @throws SQLException
     */
    public ItemNews getNewsById(int id) throws SQLException {
        String sql="select * from item_news where id=? ";
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        return queryRunner.query(sql,new BeanHandler<ItemNews>(ItemNews.class),id);
    }
}
