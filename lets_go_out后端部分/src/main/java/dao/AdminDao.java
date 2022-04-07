package dao;

import javaBean.User;

import java.util.ArrayList;

public interface AdminDao {
    //添加用户(name&password unique)
    public boolean addUser(User u) throws Exception;
    //修改密码
    public boolean editPasswd(int uid,String passwd)throws Exception;
    //根据UserID删除用户
    public boolean deleteUser(int uid)throws Exception;
    //根据用户名查询用户
    public User getUserByName(String uname)throws Exception;
    //根据UserID查询用户
    public User getUserByID(int uid) throws Exception;
    //获取所有用户信息
    public ArrayList<User> displayUser()throws Exception;
}
