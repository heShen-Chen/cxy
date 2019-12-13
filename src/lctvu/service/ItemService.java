package lctvu.service;

import lctvu.bean.Items;
import lctvu.dao.ItemDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    //创建ItemDao对象，调用dao层方法
    private ItemDao itemDao=new ItemDao();
    public boolean deleteItemsByArray(String[] arr){
        try {
            return itemDao.deleteItemsByArray(arr);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteItems(int id){
        try {
            return  itemDao.deleteItems(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addItems(Items items){
        try {
            boolean b=itemDao.addItems(items);
            if(b){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateItems(Items items){
        try {
            return itemDao.updateItems(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据id查询栏目对象
     * @return
     */
    public List<Items> getAllItems(){
        List<Items> list=new ArrayList<>();
        try {
            list=itemDao.getAllItems();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Items getItemById(int id){
        try {
            return itemDao.getItemById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
