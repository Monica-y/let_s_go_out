package dao;

import database.ConnectionFactory;
import javaBean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接
    public AdminDaoImpl(){
        this.conn = ConnectionFactory.getConnection();
    }
    @Override
    public boolean addUser(User u) throws Exception {
        String sql1 = "select count(*)+1 as num_id from kongming234.dbo.WebAdmin";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        u.setUserID(newID.getInt(1));
        String sql = "insert into kongming234.dbo.WebAdmin(userID, name, password) values (?,?,?)";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入对象数据
        this.preparedStatement.setInt(1,u.getUserID());
        this.preparedStatement.setString(2,u.getName());
        this.preparedStatement.setString(3,u.getPassword());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean editPasswd(int uid, String passwd) throws Exception {
        String sql = "update kongming234.dbo.WebAdmin set password = ? where userID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setString(1,passwd);
        this.preparedStatement.setInt(2,uid);
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean deleteUser(int uid) throws Exception {
        String sql = "delete from kongming234.dbo.WebAdmin where userID = "+uid;
        this.preparedStatement = this.conn.prepareStatement(sql);
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public User getUserByName(String uname) throws Exception {
        User u = new User();
        String sql = "select * from kongming234.dbo.WebAdmin where name = "+uname;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        resultSet.next();
        u.setUserID(resultSet.getInt(1));
        u.setName(resultSet.getString(2));
        u.setPassword(resultSet.getString(3));
        resultSet.close();
        this.preparedStatement.close();
        return u;
    }

    @Override
    public User getUserByID(int uid) throws Exception {
        User u = new User();
        String sql = "select * from kongming234.dbo.WebAdmin where userID = "+uid;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        if(!resultSet.next()){
            return null;
        }
        u.setUserID(resultSet.getInt(1));
        u.setName(resultSet.getString(2));
        u.setPassword(resultSet.getString(3));
        resultSet.close();
        this.preparedStatement.close();
        return u;
    }

    @Override
    public ArrayList<User> displayUser() throws Exception {
        ArrayList<User> userlist = new ArrayList<User>();
        String sql = "select * from kongming234.dbo.WebUser";
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            User u = new User();
            u.setUserID(resultSet.getInt(1));
            u.setName(resultSet.getString(2));
            u.setPassword(resultSet.getString(3));
            userlist.add(u);
        }
        resultSet.close();
        this.preparedStatement.close();
        return userlist;
    }
}
