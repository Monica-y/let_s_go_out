package service;

import javaBean.House;

import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:05
 */
public interface HouseService {
    //根据id获得这个旅馆的全部信息
    House getDetailInf(int id)throws Exception;

    // 获得所有旅馆的简略信息
    List<House> getAllBrief()throws Exception;
}
