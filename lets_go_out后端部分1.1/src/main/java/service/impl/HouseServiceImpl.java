package service.impl;

import dao.HouseDao;
import dao.HouseDaoImpl;
import javaBean.House;
import service.HouseService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:05
 */
public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao=new HouseDaoImpl();

    @Override
    public House getDetailInf(int id) throws Exception {
        House house = houseDao.getIDHouse(id);
        if(house==null){
            throw new Exception("通过id查找房子获得详细信息时获得的信息为空");
        }
        return house;
    }

    @Override
    public List<House> getAllBrief() throws Exception {
        List<House> houseList = houseDao.displayHouse();
        if(houseList==null){
            houseList=new ArrayList<>();
        }
        return houseList;
    }
}
