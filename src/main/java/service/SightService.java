package service;

import javaBean.Sight;

import java.util.List;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-03-31 17:06
 */
public interface SightService {
    //根据id获得这个景点的全部信息
    Sight getDetailInf(int id)throws Exception;

    // 获得所有旅馆的简略信息
    List<Sight> getAllBrief()throws Exception;
}
