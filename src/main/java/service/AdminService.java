package service;

import javaBean.House;
import javaBean.Sight;
import javaBean.User;

import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:07
 */
public interface AdminService {
    //管理员登录，返回状态码
    int adminLogin(String name,String password)throws  Exception;

    //获得所有的用户信息
    List<User> getAllInf(int adminID, String name)throws Exception;

    // 获得所有用户旅馆推荐信息
    List<House> getAllHouseRecommend(int adminID, String name)throws Exception;

    // 获得所有用户景点推荐信息
    List<Sight> getAllSightRecommend(int adminID, String name)throws Exception;

    //对用户进行删除，返回状态码
    int deleteUserByUserID(int adminID, String adminName,int userID)throws Exception;

    //对用户推荐旅馆信息进行删除，返回状态码
    int deleteRecommendHouseByHouseID(
            int adminID, String adminName,int houseID)throws Exception;

    //对用户推荐景点信息进行删除，返回状态码
    int deleteRecommendSightBySightID(
            int adminID, String adminName,int sightID)throws Exception;

    //通过用户旅馆推荐，返回状态码
    int acceptHouseRecommend(
            int adminID, String adminName,int houseID)throws Exception;

    //通过用户景点推荐，返回状态码
    int acceptSightRecommend(
            int adminID, String adminName,int sightID)throws Exception;

    //通过名字获得管理员信息（数据库中名字唯一）
    User getAdminByName(String adminName)throws Exception;



}
