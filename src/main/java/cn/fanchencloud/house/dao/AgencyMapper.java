package cn.fanchencloud.house.dao;

import cn.fanchencloud.house.entity.Agency;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/2
 * Time: 22:34
 * Description:
 *
 * @author chen
 */
@Mapper
public interface AgencyMapper {
    /**
     * 获取所有的经纪机构列表
     *
     * @return 经纪机构列表
     */
    List<Agency> getAllAgency();
}