package service;

import javaBean.HComment;
import javaBean.SiComment;

import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public interface SightCommentService {
    //根据景点id获得评论信息
    List<SiComment> getInfByID(int id)throws Exception;

     //发表评论，返回状态码
    int publishComment(int userID, int sightID,String commentInf)throws Exception;


}
