package dao;

import javaBean.SiComment;

import java.util.ArrayList;

public interface SightCommentDao {
    //添加景点评论数据(检查ID)
    public boolean addSiComment(SiComment siComments)throws Exception;
    //删除sCommentID指定景点评论数据
    public boolean deleteSiComment(int siCID) throws Exception;
    //更新sCommentID指定景点评论数据
    public boolean updateSiComment(SiComment siComments) throws Exception;
    //根据sCommentID查询景点评论数据
    public SiComment getSiCommentByID(int siCID) throws Exception;
    //根据sightID查询景点评论数据
    public ArrayList<SiComment> getCommentBySi(int sID) throws Exception;
}
