package dao;

import javaBean.HComment;

import java.util.ArrayList;

public interface HouseCommentDao {
    //添加旅馆评论数据(检查ID)
    public boolean addHComment(HComment hComments)throws Exception;
    //删除hCommentID指定旅馆评论数据
    public boolean deleteHComment(int hCID) throws Exception;
    //更新hCommentID指定旅馆评论数据
    public boolean updateHComment(HComment hComments) throws Exception;
    //根据hCommentID查询旅馆评论数据
    public HComment getHCommentByID(int hCID) throws Exception;
    //根据houseID查询旅馆评论数据
    public ArrayList<HComment> getCommentBySi(int hID) throws Exception;
}
