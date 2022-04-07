package service.impl;

import dao.*;
import javaBean.House;
import javaBean.Sight;
import javaBean.User;
import service.AdminService;
import state.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:07
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();
    private UserDao userDao=new UserDaoImpl();
    private HouseDao houseDao=new HouseDaoImpl();
    private SightDao sightDao=new SightDaoImpl();

    @Override
    public int adminLogin(String name, String password) throws Exception {
        User user=userDao.getUserByName(name);
        if(password.equals(user.getPassword())){
            return State.SUCCESS;
        }
        return State.USERNAME_PASSWORD_MISMATCH;
    }

    private boolean check(int adminID, String name) throws Exception {
        User user2 = adminDao.getUserByName(name);
        return adminID==user2.getUserID();
    }

    /**
     * 返回null说明管理员id和名字不匹配
     * @param adminID
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getAllInf(int adminID, String name) throws Exception {
        if(check(adminID,name)){
            return null;
        }

        List<User> userList=adminDao.displayUser();
        if(userList==null){
            userList=new ArrayList<>();
        }
        return userList;
    }

    @Override
    public List<House> getAllHouseRecommend(int adminID, String name) throws Exception {
        if(check(adminID,name)){
            return null;
        }

        List<House> houseList = houseDao.displayHouse();
        for(int i=0;i<houseList.size();i++){
            if(houseList.get(i).getStatus()==1){
                houseList.remove(i);
            }
        }
        if(houseList==null){
            houseList=new ArrayList<>();
        }
        return houseList;
    }

    @Override
    public List<Sight> getAllSightRecommend(int adminID, String name) throws Exception {
        if(check(adminID,name)){
            return null;
        }

        List<Sight> sightList = sightDao.displaySight();
        for(int i=0;i<sightList.size();i++){
            if(sightList.get(i).getStatus()==1){
                sightList.remove(i);
            }
        }
        if(sightList==null){
            sightList=new ArrayList<>();
        }
        return sightList;
    }

    @Override
    public int deleteUserByUserID(int adminID, String adminName, int userID) throws Exception {
        if(check(adminID,adminName)){
            return State.ADMIN_ID_USERNAME_MISMATCH;
        }
        boolean flag=userDao.deleteUser(userID);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    @Override
    public int deleteRecommendHouseByHouseID(int adminID, String adminName, int houseID) throws Exception {
        if(check(adminID,adminName)){
            return State.ADMIN_ID_USERNAME_MISMATCH;
        }

        House house = houseDao.getIDHouse(houseID);
        if(house.getStatus()==1){
            throw new Exception("审核推荐房子时状态为已通过推荐");
        }

        boolean flag = houseDao.deleteHouse(houseID);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    @Override
    public int deleteRecommendSightBySightID(int adminID, String adminName, int sightID) throws Exception {
        if(check(adminID,adminName)){
            return State.ADMIN_ID_USERNAME_MISMATCH;
        }

        Sight sight = sightDao.getIDSight(sightID);
        if(sight.getStatus()==1){
            throw new Exception("审核推荐景点时状态为已通过推荐");
        }

        boolean flag = sightDao.deleteSight(sightID);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    @Override
    public int acceptHouseRecommend(int adminID, String adminName, int houseID) throws Exception {
        if(check(adminID,adminName)){
            return State.ADMIN_ID_USERNAME_MISMATCH;
        }

        House house = houseDao.getIDHouse(houseID);
        house.setStatus(1);
        boolean flag = houseDao.updateHouse(house);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    @Override
    public int acceptSightRecommend(int adminID, String adminName, int sightID) throws Exception {
        if(check(adminID,adminName)){
            return State.ADMIN_ID_USERNAME_MISMATCH;
        }

        Sight sight = sightDao.getIDSight(sightID);
        sight.setStatus(1);
        boolean flag = sightDao.updateSight(sight);
        if(flag){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    @Override
    public User getAdminByName(String adminName) throws Exception {
        User user = adminDao.getUserByName(adminName);
        return user;
    }
}
