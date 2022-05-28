package dao;
import javaBean.Sight;

import java.util.ArrayList;
import java.util.List;
public interface SightDao {
    //添加景点数据(检查ID)
    public boolean addSight(Sight sights)throws Exception;
    //删除SightID指定景点数据
    public boolean deleteSight(int SightID) throws Exception;
    //更新SightID指定景点数据
    public boolean updateSight(Sight sights) throws Exception;
    //根据SightID查询景点数据
    public Sight getIDSight(int SightID) throws Exception;
    //输入关键字查询景点(搜索范围为景点名称,景点信息,景点地址)
    public ArrayList<Sight> searchKeyword(String KeyWord)throws Exception;
    //输出所有景点数据
    public List<Sight> displaySight() throws Exception;
}
