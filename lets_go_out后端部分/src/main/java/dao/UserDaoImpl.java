package dao;

import database.ConnectionFactory;
import javaBean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接
//    public UserDaoImpl(Connection conn){this.conn = conn;}
    public UserDaoImpl() {
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public boolean addUser(User u) throws Exception {
        String sql1 = "select count(*)+1 as id_num from kongming234.dbo.WebUser";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        u.setUserID(newID.getInt(1));
        String sql = "insert into kongming234.dbo.WebUser(userID, name, password) values (?,?,?)";
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
        String sql = "update kongming234.dbo.WebUser set password = ? where userID = ?";
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
        //默认在删掉用户之前执行删除用户所有评论的操作
        String sql1 = "delete from kongming234.dbo.SiComment where userID = "+uid;
        this.preparedStatement = this.conn.prepareStatement(sql1);
        this.preparedStatement.executeUpdate();
        String sql2 = "delete from kongming234.dbo.HComment where userID = "+uid;
        this.preparedStatement = this.conn.prepareStatement(sql2);
        this.preparedStatement.executeUpdate();
        String sql3 = "delete from kongming234.dbo.WebUser where userID = "+uid;
        this.preparedStatement = this.conn.prepareStatement(sql3);
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
        String sql = "select * from kongming234.dbo.WebUser where name = "+uname;
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
        String sql = "select * from kongming234.dbo.WebUser where userID = "+uid;
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
}
