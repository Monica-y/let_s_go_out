package dao;

import database.ConnectionFactory;
import javaBean.Sight;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SightDaoImpl implements SightDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接，紧耦合
//    public SightDaoImpl(Connection conn){
//        this.conn = conn;
//    }
    public SightDaoImpl() {
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public boolean addSight(Sight sights) throws Exception {
        String sql1 = "select count(*)+1 as id_num from kongming234.dbo.Sight";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        sights.setSightID(newID.getInt(1));
        String sql = "insert into kongming234.dbo.Sight(sightID, sightPho, sightName, sightInfo, sightAddress, status)" +
                             "values (?,?,?,?,?,?)";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入对象数据
        this.preparedStatement.setInt(1,sights.getSightID());
        this.preparedStatement.setString(2,sights.getSightPho());
        this.preparedStatement.setString(3,sights.getSightName());
        this.preparedStatement.setString(4,sights.getSightInfo());
        this.preparedStatement.setString(5,sights.getSightAddress());
        this.preparedStatement.setInt(6,sights.getStatus());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean deleteSight(int SightID) throws Exception {
        String sql = "delete from kongming234.dbo.Sight where sightID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入数据
        this.preparedStatement.setInt(1,SightID);
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean updateSight(Sight sights) throws Exception {
        String sql = "update kongming234.dbo.Sight set sightPho = ?,sightName = ?,sightInfo = ?,sightAddress = ?,status = ? " +
                             "where sightID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setString(1,sights.getSightPho());
        this.preparedStatement.setString(2,sights.getSightName());
        this.preparedStatement.setString(3,sights.getSightInfo());
        this.preparedStatement.setString(4,sights.getSightAddress());
        this.preparedStatement.setInt(5,sights.getStatus());
        this.preparedStatement.setInt(6,sights.getSightID());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Sight getIDSight(int SightID) throws Exception {
        Sight sights = new Sight();
        String sql = "select * from kongming234.dbo.Sight where sightID = "+SightID;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        if(!resultSet.next()){
            return null;
        }
        sights.setSightID(resultSet.getInt(1));
        sights.setSightPho(resultSet.getString(2));
        sights.setSightName(resultSet.getString(3));
        sights.setSightInfo(resultSet.getString(4));
        sights.setSightAddress(resultSet.getString(5));
        sights.setStatus(resultSet.getInt(6));
        resultSet.close();;
        this.preparedStatement.close();
        return sights;
    }

    @Override
    public ArrayList<Sight> searchKeyword(String KeyWord) throws Exception {
        ArrayList<Sight> sightList = new ArrayList<Sight>();
        String sql = "select * from kongming234.dbo.Sight where sightName like '%"+KeyWord+"%' or sightInfo like '%"+KeyWord+"%' or  sightAddress like '%"+KeyWord+"%'";
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            Sight sights = new Sight();
            sights.setSightID(resultSet.getInt(1));
            sights.setSightPho(resultSet.getString(2));
            sights.setSightName(resultSet.getString(3));
            sights.setSightInfo(resultSet.getString(4));
            sights.setSightAddress(resultSet.getString(5));
            sights.setStatus(resultSet.getInt(6));
            sightList.add(sights);
        }
        resultSet.close();
        this.preparedStatement.close();
        return sightList;
    }

    @Override
    public List<Sight> displaySight() throws Exception {
        ArrayList<Sight> sightList = new ArrayList<Sight>();
        String sql = "select * from kongming234.dbo.Sight";
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            Sight sights = new Sight();
            sights.setSightID(resultSet.getInt(1));
            sights.setSightPho(resultSet.getString(2));
            sights.setSightName(resultSet.getString(3));
            sights.setSightInfo(resultSet.getString(4));
            sights.setSightAddress(resultSet.getString(5));
            sights.setStatus(resultSet.getInt(6));
            sightList.add(sights);
        }
        resultSet.close();
        this.preparedStatement.close();
        return sightList;
    }
}
