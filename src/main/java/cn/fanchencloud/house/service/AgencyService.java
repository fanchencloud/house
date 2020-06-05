package cn.fanchencloud.house.service;

import cn.fanchencloud.house.entity.Agency;

import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 1:24
 * Description: 经纪机构服务接口
 *
 * @author chen
 */
public interface AgencyService {
    /**
     * 获取所有的经纪机构列表
     *
     * @return 经纪机构列表
     */
    List<Agency> getAllAgency();
}
