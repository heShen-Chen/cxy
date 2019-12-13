package lctvu.dao;

import lctvu.bean.Items;
import lctvu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
    /**
     * 删除id在数组arr中的元素。
     * @param arr
     * @return
     * @throws SQLException
     */
    public boolean deleteItemsByArray(String[] arr) throws SQLException {
        String str="";
        for(int i=0;i<arr.length;i++){
            str=str+arr[i]+",";
        }
        str=str.substring(0,str.length()-1);//去掉最后一个逗号
        String sql="delete from itemt where id in ("+str+")";

        System.out.println(str);
        int n=runner.update(sql);
        if(n>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteItems(int id) throws SQLException {
        String sql="delete from itemt where id=?";
        int n=runner.update(sql,id);
        if(n>0){
            return true;
        }
        return false;
    }
    public boolean addItems(Items items) throws SQLException {
        String sql="insert into itemt(itemname) values(?)";
        int n=runner.update(sql,items.getItemname());
        if(n>0){
            return true;
        }
        return false;

    }
    public boolean updateItems(Items items) throws SQLException {
        String sql="update itemt set itemname=? where id=?";
        int n=runner.update(sql,items.getItemname(),items.getId());
        if(n>0){
            return true;
        }
        return false;
    }
    public List<Items> getAllItems() throws SQLException {
        String sql="select * from itemt";
        List<Items> list=new ArrayList<>();
        list=runner.query(sql,new BeanListHandler<>(Items.class));
        return list;
    }
    /**
     * 根据id查询分类对象
     * @param id
     * @return
     * @throws SQLException
     */
    public Items getItemById(int id) throws SQLException {
        String sql="select * from itemt where id=?";
        Items items=runner.query(sql,new BeanHandler<>(Items.class),id);
        return items;
    }
}
