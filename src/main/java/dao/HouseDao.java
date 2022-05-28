package dao;

import javaBean.House;
import javaBean.Sight;

import java.util.ArrayList;

public interface HouseDao {
    //添加旅馆数据(检查ID)
    public boolean addHouse(House houses)throws Exception;
    //删除houseID指定旅馆数据
    public boolean deleteHouse(int HouseID) throws Exception;
    //更新houseID指定旅馆数据
    public boolean updateHouse(House houses) throws Exception;
    //根据houseID查询旅馆数据
    public House getIDHouse(int HouseID) throws Exception;
    //输入关键字查询旅店(搜索范围为旅店名称,旅店信息,旅店地址)
    public ArrayList<House> SearchKeyword(String KeyWord)throws Exception;
    //输出所有旅店数据
    public ArrayList<House> displayHouse()throws Exception;
}
