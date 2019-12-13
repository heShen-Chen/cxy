package lctvu.dao;

import lctvu.bean.User;
import lctvu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
    public User getUserByNameAndPass(String username,String password) throws SQLException {
        String sql="select * from user where username=? and password=?";
        User user=queryRunner.query(sql,new BeanHandler<>(User.class),username,password);
        return user;
    }
    public List<User> getAllUser() throws SQLException {
        String sql="select * from user";
        List<User> list=queryRunner.query(sql,new BeanListHandler<>(User.class));
        return list;
    }
    public User getUserByid(int id) throws SQLException {
        String sql="select * from user where id=?";
        User user=  queryRunner.query(sql,new BeanHandler<>(User.class),id);
        return user;
    }
    public boolean updateUser(User user) throws SQLException {
        String sql="update user set username=?,password=?,email=?,tdate=? where id=?";
        int n=queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getTdate(),user.getId());
        if(n>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteUser(int id) throws SQLException {
        String sql="delete from user where id=?";
        int n=queryRunner.update(sql,id);
        if(n>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean addUser(User user) throws SQLException {
        String sql="insert into user(username,password,email,tdate) values(?,?,?,?)";
        int n=queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getTdate());
        if(n>0){
            return true;
        }else {
            return false;
        }
    }
}
