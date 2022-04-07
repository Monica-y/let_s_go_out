package dao;

import javaBean.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class TestDao {
    public static void main(String[] args) throws Exception {
//        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=KONGMING234";
//        String username = "sa";
//        String password = "892599";
//        //加载驱动
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //连接数据库
//        Connection connection = DriverManager.getConnection(url, username, password);
        Sight sights = new Sight();
        SightDaoImpl sightsql = new SightDaoImpl();


        //测试SightDaoImpl接口方法

        //测试addSight方法,不需要指定sightID
//        sights.setSightPho("2");
//        sights.setSightName("2");
//        sights.setSightInfo("2");
//        sights.setSightAddress("5");
//        sights.setStatus(0);
//        if(sightsql.addSight(sights)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error!");
//        }

        //测试deleteSight方法
//        if(sightsql.deleteSight(2)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error!");
//        }

        //测试updateSight方法
//        sights.setSightID(2);
//        sights.setSightPho("2");
//        sights.setSightName("2");
//        sights.setSightInfo("2");
//        sights.setSightAddress("5");
//        sights.setStatus(0);
//        System.out.println(sights);
//        if(sightsql.updateSight(sights)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error!");
//        }

        //测试getIDSight方法
//        System.out.println(sightsql.getIDSight(2));

        //测试searchKeyword方法
//        ArrayList<Sight> sightList = sightsql.searchKeyword("2");
//        System.out.println(sightList.toString());

        //测试displaySight方法
//        System.out.println(sightsql.displaySight().toString());


        //测试HouseDaoImpl接口方法

        //测试addHouse方法,不需要设置houseID
//        House houses = new House();
//        HouseDaoImpl housesql = new HouseDaoImpl();
//        houses.setHousePho("2");
//        houses.setHouseName("2");
//        houses.setHouseInfo("2");
//        houses.setHouseAddress("2");
//        houses.setStatus(0);
//        if(housesql.addHouse(houses)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error!");
//        }

        //测试deleteHouse方法
//        if(housesql.deleteHouse(1)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error");
//        }

        //测试updateHouse方法
//        houses.setHouseID(2);
//        houses.setHousePho("2");
//        houses.setHouseName("2");
//        houses.setHouseInfo("2");
//        houses.setHouseAddress("2");
//        houses.setStatus(0);
//        if(housesql.updateHouse(houses)){
//            System.out.println("success!");
//        }else{
//            System.out.println("error!");
//        }

        //测试getIDHouse方法
//        System.out.println(housesql.getIDHouse(2));

        //测试searchKeyword方法
//        System.out.println(housesql.SearchKeyword("2"));

        //测试displayHouse方法
//        System.out.println(housesql.displayHouse());


        //测试SightCommentDaolmpl接口方法

        //测试addSiComment方法,不需要设置ID
        SiComment siComments = new SiComment();
        SightCommentDaoImpl siCommentsql = new SightCommentDaoImpl();
//        siComments.setSightID(2);
//        siComments.setUserID(2);
//        siComments.setDate(new Date());
//        siComments.setsComment("1");
//        if(siCommentsql.addSiComment(siComments)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试deleteSiComment方法
//        if(siCommentsql.deleteSiComment(2)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试updateSiComment方法
//        siComments.setsCommentID(2);
//        siComments.setSightID(2);
//        siComments.setUserID(2);
//        siComments.setDate(new Date());
//        siComments.setsComment("1");
//        if(siCommentsql.updateSiComment(siComments)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试getSiCommentByID方法
//        System.out.println(siCommentsql.getSiCommentByID(1));

        //测试getCommentBySi方法
//        System.out.println(siCommentsql.getCommentBySi(1));


        //测试HouseCommentDaoImpl接口方法
        //测试addHComment方法,不需要设置id
        HComment hComments = new HComment();
        HouseCommentDaoImpl hCommentsql = new HouseCommentDaoImpl();
//        hComments.setHouseID(1);
//        hComments.setUserID(1);
//        hComments.setData(new Date());
//        hComments.sethComment("222222");
//        if(hCommentsql.addHComment(hComments)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试deleteHComment方法
//        if(hCommentsql.deleteHComment(1)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试updateHComment方法
//        hComments.sethCommentID(2);
//        hComments.setHouseID(1);
//        hComments.setUserID(2);
//        hComments.setData(new Date());
//        hComments.sethComment("22222");
//        if(hCommentsql.updateHComment(hComments)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试getHCommentByID方法
//        System.out.println(hCommentsql.getHCommentByID(1));

        //测试getCommentBySi方法
//        System.out.println(hCommentsql.getCommentBySi(1));


        //测试UserDaoImpl接口方法
        //测试addUser方法
        User u = new User();
        UserDaoImpl usersql = new UserDaoImpl();
//        u.setName("5");
//        u.setPassword("1");
//        if(usersql.addUser(u)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试editPasswd
//        if(usersql.editPasswd(1,"kongming")){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试deleteUser方法
//        if(usersql.deleteUser(1)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试getUserByName方法
//        System.out.println(usersql.getUserByName("2"));

        //测试getUserByID方法
//        System.out.println(usersql.getUserByID(1));


        //测试AdminDaoImpl接口方法
        //测试addUser方法
        AdminDaoImpl adminsql = new AdminDaoImpl();
//        u.setName("2");
//        u.setPassword("2");
//        if(adminsql.addUser(u)){
//            System.out.println("success");
//        }else{
//            System.out.println("error");
//        }

        //测试editPasswd方法
//        System.out.println(adminsql.editPasswd(2,"kongming2"));

        //测试deleteUser方法
//        System.out.println(adminsql.deleteUser(1));

        //测试getUserByName方法
//        System.out.println(adminsql.getUserByName("1"));

        //测试getUserByID方法
//        System.out.println(adminsql.getUserByID(1));

        //测试displayUser方法
//        System.out.println(adminsql.displayUser());
    }
}
