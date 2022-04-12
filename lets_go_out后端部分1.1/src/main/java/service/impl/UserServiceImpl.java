package service.impl;

import dao.*;
import javaBean.House;
import javaBean.Sight;
import javaBean.User;
import org.apache.commons.fileupload.FileItem;
import service.UserService;
import state.State;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    private HouseDao houseDao=new HouseDaoImpl();
    private SightDao sightDao=new SightDaoImpl();

    @Override
    public int registerUser(String uname, String password) throws Exception {
        User user=userDao.getUserByName(uname);
        if(user!=null){
            return State.USERNAME_EXISES;
        }

        user=new User();
        user.setName(uname);
        user.setPassword(password);
        boolean flag = userDao.addUser(user);
        if(flag){
            return State.SUCCESS;
        }

        return State.UNKNOW_ERROR;
    }

    @Override
    public int userLogin(String uname, String password) throws Exception {
        User user = userDao.getUserByName(uname);
        if(user.getPassword().equals(password)){
            return State.SUCCESS;
        }
        return State.UNKNOW_ERROR;
    }

    /**
     *
     * @param userID
     * @param list
     * @param name
     * @param describe
     * @param address
     * @param savePath 传入的是要放的目录的路径（绝对相对都行）
     * @return
     * @throws Exception
     */
    @Override
    public int recommendHouse(
            int userID, List<FileItem> list, String name,
            String describe, String address,String savePath) throws Exception {
        String filePath=UserServiceImpl.saveImg(savePath,list);
        House house=new House();
        house.setStatus(0);
        house.setHouseAddress(address);
        house.setHousePho(filePath);
        house.setHouseInfo(describe);
        house.setHouseName(name);
        boolean flag = houseDao.addHouse(house);
        if(flag){
            return State.SUCCESS;
        }

        return State.UNKNOW_ERROR;
    }

    @Override
    public int recommendSight(
            int userID, List<FileItem> list, String name,
            String describe, String address,String savePath) throws Exception {
        String filePath=UserServiceImpl.saveImg(savePath,list);
        Sight sight=new Sight();
        sight.setStatus(0);
        sight.setSightAddress(address);
        sight.setSightPho(filePath);
        sight.setSightInfo(describe);
        sight.setSightName(name);
        boolean flag = sightDao.addSight(sight);
        if(flag){
            return State.SUCCESS;
        }

        return State.UNKNOW_ERROR;
    }

    @Override
    public User getUserByName(String userName) throws Exception {
        User user = userDao.getUserByName(userName);
        return user;
    }

    @Override
    public User getUserByID(int id) throws Exception {
        User user = userDao.getUserByID(id);
        return user;
    }

    //返回包括图片名称的保存图片的路径
    private static String saveImg(String savePath,List<FileItem> fileItemsList) {
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            boolean flag=file.mkdirs();
            System.out.println(flag);
        }

        try {
            for (FileItem item : fileItemsList) {
                //如果fileitem中封装的是上传文件
                if (!item.isFormField()) {
                    //得到上传的文件名称，
                    String filename = item.getName();
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    String fileSuffix = filename.substring(filename.lastIndexOf("."));
                    String filePath = UserServiceImpl.generateUUIDPath(savePath,fileSuffix);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(filePath);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return savePath;
    }

    private static String generateUUIDPath(String savePath,String fileSuffix){
        String uuid = null;
        String filePath =null;
        File file=null;
        while (true){
            uuid=UUID.randomUUID().toString().replaceAll("-", "");
            filePath=savePath+"\\" + uuid + fileSuffix;
            file=new File(filePath);
            if (!file.exists()) {
                break;
            }
        }
        return filePath;
    }


}
