package service;

import javaBean.HComment;


import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 22:19
 */
public interface HouseCommentService {
    //根据旅馆id获得评论信息
    List<HComment> getInfByHouseID(int houseID)throws Exception;

    //发表评论，返回状态码
    int publishComment(int userID, int houseID,String commentInf) throws Exception;
}
