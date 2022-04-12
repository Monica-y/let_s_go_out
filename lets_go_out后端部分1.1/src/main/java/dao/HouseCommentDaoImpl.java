package dao;

import database.ConnectionFactory;
import javaBean.HComment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HouseCommentDaoImpl implements HouseCommentDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接
//    public HouseCommentDaoImpl(Connection conn){this.conn = conn;}
    public HouseCommentDaoImpl() {
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public boolean addHComment(HComment hComments) throws Exception {
        String sql1 = "select count(*)+1 as id_num from kongming234.dbo.HComment";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        hComments.sethCommentID(newID.getInt(1));
        String sql = "insert into kongming234.dbo.HComment(hCommentID, houseID, userID, date, hComment) values (?,?,?,?,?)";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入对象数据
        this.preparedStatement.setInt(1,hComments.gethCommentID());
        this.preparedStatement.setInt(2,hComments.getHouseID());
        this.preparedStatement.setInt(3,hComments.getUserID());
        this.preparedStatement.setDate(4,new Date(hComments.getDate().getTime()));
        this.preparedStatement.setString(5,hComments.gethComment());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean deleteHComment(int hCID) throws Exception {
        String sql = "delete from kongming234.dbo.HComment where hCommentID = "+hCID;
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
    public boolean updateHComment(HComment hComments) throws Exception {
        String sql = "update kongming234.dbo.HComment set houseID = ?,userID = ?,hComment = ? where hCommentID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setInt(1,hComments.getHouseID());
        this.preparedStatement.setInt(2,hComments.getUserID());
        this.preparedStatement.setString(3,hComments.gethComment());
        this.preparedStatement.setInt(4,hComments.gethCommentID());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public HComment getHCommentByID(int hCID) throws Exception {
        HComment hComments = new HComment();
        String sql = "select * from kongming234.dbo.HComment where hCommentID = "+hCID;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        if(!resultSet.next()){
            return null;
        }
        hComments.sethCommentID(resultSet.getInt(1));
        hComments.setHouseID(resultSet.getInt(2));
        hComments.setUserID(resultSet.getInt(3));
        hComments.setDate(resultSet.getDate(4));
        hComments.sethComment(resultSet.getString(5));
        resultSet.close();
        this.preparedStatement.close();
        return hComments;
    }

    @Override
    public ArrayList<HComment> getCommentBySi(int hID) throws Exception {
        ArrayList<HComment> hCommentArrayList = new ArrayList<HComment>();
        String sql = "select * from kongming234.dbo.HComment where houseID = "+hID;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            HComment hComments = new HComment();
            hComments.sethCommentID(resultSet.getInt(1));
            hComments.setHouseID(resultSet.getInt(2));
            hComments.setUserID(resultSet.getInt(3));
            hComments.setDate(resultSet.getDate(4));
            hComments.sethComment(resultSet.getString(5));
            hCommentArrayList.add(hComments);
        }
        resultSet.close();
        this.preparedStatement.close();
        return hCommentArrayList;
    }
}
