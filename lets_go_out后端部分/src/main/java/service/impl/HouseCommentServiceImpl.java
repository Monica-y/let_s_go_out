package service.impl;

import dao.HouseCommentDao;
import dao.HouseCommentDaoImpl;
import dao.HouseDao;
import dao.HouseDaoImpl;
import javaBean.HComment;
import javaBean.House;
import service.HouseCommentService;
import service.HouseService;
import state.State;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 22:19
 */
public class HouseCommentServiceImpl implements HouseCommentService {
    private HouseCommentDao houseCommentDao=new HouseCommentDaoImpl();

    @Override
    public List<HComment> getInfByHouseID(int houseID)throws Exception{
        List<HComment> houseCommentList = houseCommentDao.getCommentByID(houseID);
        if(houseCommentList==null){
            houseCommentList=new ArrayList<>();
        }
        return houseCommentList;
    }

    @Override
    public int publishComment(int userID, int houseID,String commentInf) throws Exception {
        HComment hComment=new HComment();
        hComment.sethComment(commentInf);
        hComment.setUserID(userID);
        hComment.setHouseID(houseID);
        hComment.setDate(new Date());
        boolean flag = houseCommentDao.addHComment(hComment);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }
}
