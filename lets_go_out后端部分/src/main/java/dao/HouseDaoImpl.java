package dao;

import database.ConnectionFactory;
import javaBean.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HouseDaoImpl implements HouseDao{
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //通过构造方法取得数据库连接
//    public HouseDaoImpl(Connection conn){this.conn = conn;}
    public HouseDaoImpl() {
        this.conn = ConnectionFactory.getConnection();
    }
    @Override
    public boolean addHouse(House houses) throws Exception {
        String sql1 = "select count(*)+1 as id_num from kongming234.dbo.House";
        this.preparedStatement = this.conn.prepareStatement(sql1);
        ResultSet newID = this.preparedStatement.executeQuery();
        newID.next();
        houses.setHouseID(newID.getInt(1));
        String sql = "insert into kongming234.dbo.House(houseID, housePho, houseName, houseInfo, houseAddress, status)"+"values (?,?,?,?,?,?)";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入对象数据
        this.preparedStatement.setInt(1,houses.getHouseID());
        this.preparedStatement.setString(2,houses.getHousePho());
        this.preparedStatement.setString(3,houses.getHouseName());
        this.preparedStatement.setString(4,houses.getHouseInfo());
        this.preparedStatement.setString(5,houses.getHouseAddress());
        this.preparedStatement.setInt(6,houses.getStatus());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean deleteHouse(int HouseID) throws Exception {
        String sql = "delete from kongming234.dbo.House where houseID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        //向preparedStatement中写入数据
        this.preparedStatement.setInt(1,HouseID);
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();;
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean updateHouse(House houses) throws Exception {
        String sql = "update kongming234.dbo.House set housePho = ?,houseName = ?,houseInfo = ?,houseAddress = ?,status = ? where houseID = ?";
        this.preparedStatement = this.conn.prepareStatement(sql);
        this.preparedStatement.setString(1,houses.getHousePho());
        this.preparedStatement.setString(2,houses.getHouseName());
        this.preparedStatement.setString(3,houses.getHouseInfo());
        this.preparedStatement.setString(4,houses.getHouseAddress());
        this.preparedStatement.setInt(5,houses.getStatus());
        this.preparedStatement.setInt(6,houses.getHouseID());
        int result = this.preparedStatement.executeUpdate();
        this.preparedStatement.close();
        if(result == 0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public House getIDHouse(int HouseID) throws Exception {
        House houses = new House();
        String sql = "select * from kongming234.dbo.House where houseID = "+HouseID;
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        resultSet.next();
        houses.setHouseID(resultSet.getInt(1));
        houses.setHousePho(resultSet.getString(2));
        houses.setHouseName(resultSet.getString(3));
        houses.setHouseInfo(resultSet.getString(4));
        houses.setHouseAddress(resultSet.getString(5));
        houses.setStatus(resultSet.getInt(6));
        resultSet.close();
        this.preparedStatement.close();
        return houses;
    }

    @Override
    public ArrayList<House> SearchKeyword(String KeyWord) throws Exception {
        ArrayList<House> houseList = new ArrayList<House>();
        String sql = "select * from kongming234.dbo.House where houseName like '%"+KeyWord+"%' or houseInfo like '%"+KeyWord+"%' or  houseAddress like '%"+KeyWord+"%'";
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while (resultSet.next()){
            House houses = new House();
            houses.setHouseID(resultSet.getInt(1));
            houses.setHousePho(resultSet.getString(2));
            houses.setHouseName(resultSet.getString(3));
            houses.setHouseInfo(resultSet.getString(4));
            houses.setHouseAddress(resultSet.getString(5));
            houses.setStatus(resultSet.getInt(6));
            houseList.add(houses);
        }
        resultSet.close();
        this.preparedStatement.close();
        return houseList;
    }

    @Override
    public ArrayList<House> displayHouse() throws Exception {
        ArrayList<House> houseList = new ArrayList<House>();
        String sql = "select * from kongming234.dbo.House";
        this.preparedStatement = this.conn.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while(resultSet.next()){
            House houses = new House();
            houses.setHouseID(resultSet.getInt(1));
            houses.setHousePho(resultSet.getString(2));
            houses.setHouseName(resultSet.getString(3));
            houses.setHouseInfo(resultSet.getString(4));
            houses.setHouseAddress(resultSet.getString(5));
            houses.setStatus(resultSet.getInt(6));
            houseList.add(houses);
        }
        resultSet.close();
        this.preparedStatement.close();
        return houseList;
    }
}
