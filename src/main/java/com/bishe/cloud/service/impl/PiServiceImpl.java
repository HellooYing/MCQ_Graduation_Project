package com.bishe.cloud.service.impl;

import com.bishe.cloud.dao.PiDAO;
import com.bishe.cloud.model.Pi;
import com.bishe.cloud.service.PiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 6:36 下午
 */
@Service
public class PiServiceImpl implements PiService {
    @Resource
    PiDAO piDAO;

    @Override
    public int addPi(Pi pi) {
        return piDAO.insertSelective(pi);
    }

    @Override
    public int deletePi(long id) {
        return piDAO.deleteByPrimaryKey(new Pi(id));
    }

    @Override
    public int updatePi(Pi pi) {
        return piDAO.updateByPrimaryKeySelective(pi);
    }

    @Override
    public Pi getPi(long id) {
        return piDAO.selectByPrimaryKey(new Pi(id));
    }
}
