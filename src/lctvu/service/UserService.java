package lctvu.service;

import lctvu.bean.User;
import lctvu.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao=new UserDao();
    public User getUserByNameAndPass(String username,String password){
        try {
            return userDao.getUserByNameAndPass(username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<User> getAllUser(){
        try {
            return userDao.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User getUserByid(int id){
        try {
            return userDao.getUserByid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateUser(User user){
        try {
            return userDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(int id){
        try {
            return  userDao.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addUser(User user){
        try {
            return userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
