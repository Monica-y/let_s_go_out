package service;

import javaBean.User;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public interface UserService {
    //注册用户，返回是否成功注册
    int registerUser(String uname,String password)throws Exception;

    //用户登录，返回状态码
    int userLogin(String uname,String password)throws Exception;

    //用户推荐旅馆，返回状态码，需要将图片存到对应路径上
    int recommendHouse(
            int userID, List<FileItem> list,
            String name,String describe,
            String address,String savePath)throws Exception;

    //用户推荐景点，返回状态码，需要将图片存到对应路径上
    int recommendSight(
            int userID, List<FileItem> list,
            String name,String describe,
            String address,String savePath)throws Exception;

    User getUserByName(String userName)throws Exception;

    User getUserByID(int id)throws Exception;

}
