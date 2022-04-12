package service.impl;

import dao.SightDao;
import dao.SightDaoImpl;
import javaBean.House;
import javaBean.Sight;
import service.SightService;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public class SightServiceImpl implements SightService {
    private SightDao sightDao=new SightDaoImpl();
    @Override
    public Sight getDetailInf(int id) throws Exception {
        Sight sight = sightDao.getIDSight(id);
        if(sight==null){
            throw new Exception("通过id查找热门景点获得详细信息时获得的信息为空");
        }
        return sight;
    }

    @Override
    public List<Sight> getAllBrief() throws Exception {
        List<Sight> sightList = sightDao.displaySight();
        if(sightList==null){
            sightList=new ArrayList<>();
        }
        return sightList;
    }
}
