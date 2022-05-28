package dao;

import database.ConnectionFactory;
import javaBean.SiComment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SightCommentDaoImpl implements SightCommentDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接
//    public SightCommentDaoImpl(Connection conn){this.conn = conn;}
    public SightCommentDaoImpl() {
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public boolean addSiComment(SiComment siComments) throws Exception {
        String sql1 = "select max(SiComment.sCommentID) from SiComment";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        siComments.setCommentID(newID.getInt(1)+1);
        String sql = "insert into kongming234.dbo.SiComment(sCommentID, sightID, userID, date, sComment) " +
                             "values (?,?,?,?,?)";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入对象数据
        this.preparedStatement.setInt(1,siComments.getCommentID());
        this.preparedStatement.setInt(2,siComments.getSightID());
        this.preparedStatement.setInt(3,siComments.getUserID());
        this.preparedStatement.setDate(4,new Date(siComments.getDate().getTime()));
        this.preparedStatement.setString(5,siComments.getComment());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean deleteSiComment(int siCID) throws Exception {
        String sql = "delete from kongming234.dbo.SiComment where sCommentID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement对象中写入数据
        this.preparedStatement.setInt(1,siCID);
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean updateSiComment(SiComment siComments) throws Exception {
        String sql = "update kongming234.dbo.SiComment set sightID = ?,userID = ?,sComment = ? " +
                             "where sCommentID = ?";
        this.preparedStatement = this.conn.prepareStatement((sql));
        this.preparedStatement.setInt(1,siComments.getSightID());
        this.preparedStatement.setInt(2,siComments.getUserID());
        this.preparedStatement.setString(3,siComments.getComment());
        int result = this.preparedStatement.executeUpdate();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public SiComment getSiCommentByID(int siCID) throws Exception {
        SiComment siComments = new SiComment();
        String sql = "select * from kongming234.dbo.SiComment where sCommentID = ? ";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setInt(1,siCID);
        resultSet = this.preparedStatement.executeQuery();
        if(!resultSet.next()){
            return null;
        }
        siComments.setCommentID(resultSet.getInt(1));
        siComments.setSightID(resultSet.getInt(2));
        siComments.setUserID(resultSet.getInt(3));
        siComments.setDate(resultSet.getDate(4));
        siComments.setComment(resultSet.getString(5));
        resultSet.close();
        this.preparedStatement.close();
        return siComments;
    }

    @Override
    public ArrayList<SiComment> getCommentBySi(int sID) throws Exception {
        ArrayList<SiComment> siCommentArrayList = new ArrayList<SiComment>();
        String sql = "select * from kongming234.dbo.SiComment where sightID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setInt(1,sID);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            SiComment siComments = new SiComment();
            siComments.setCommentID(resultSet.getInt(1));
            siComments.setSightID(resultSet.getInt(2));
            siComments.setUserID(resultSet.getInt(3));
            siComments.setDate(resultSet.getDate(4));
            siComments.setComment(resultSet.getString(5));
            siCommentArrayList.add(siComments);
        }
        resultSet.close();
        this.preparedStatement.close();
        return siCommentArrayList;
    }
}
