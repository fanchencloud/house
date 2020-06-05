package cn.fanchencloud.house.service.impl;

import cn.fanchencloud.house.dao.AgencyMapper;
import cn.fanchencloud.house.entity.Agency;
import cn.fanchencloud.house.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by handsome programmer.
 * User: chen
 * Date: 2020/6/6
 * Time: 1:25
 * Description:
 *
 * @author chen
 */
@Service
public class AgencyServiceImpl implements AgencyService {
    /**
     * 注入经纪机构持久层
     */
    private AgencyMapper agencyMapper;

    @Override
    public List<Agency> getAllAgency() {
        return agencyMapper.getAllAgency();
    }

    @Autowired
    public void setAgencyMapper(AgencyMapper agencyMapper) {
        this.agencyMapper = agencyMapper;
    }
}
