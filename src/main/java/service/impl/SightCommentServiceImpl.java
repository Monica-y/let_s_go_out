package service.impl;

import dao.SightCommentDao;
import dao.SightCommentDaoImpl;
import javaBean.HComment;
import javaBean.SiComment;
import javaBean.Sight;
import service.SightCommentService;
import state.State;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public class SightCommentServiceImpl implements SightCommentService {
    private SightCommentDao sightCommentDao=new SightCommentDaoImpl();

    @Override
    public List<SiComment> getInfByID(int id) throws Exception {
        List<SiComment> sightCommentList = sightCommentDao.getCommentBySi(id);
        if(sightCommentList==null){
            sightCommentList=new ArrayList<>();
        }
        return sightCommentList;
    }

    @Override
    public int publishComment(int userID, int sightID,String commentInf) throws Exception {
        SiComment siComment=new SiComment();
        siComment.setComment(commentInf);
        siComment.setUserID(userID);
        siComment.setSightID(sightID);
        siComment.setDate(new Date());
        boolean flag = sightCommentDao.addSiComment(siComment);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }
}
