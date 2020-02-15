package com.bishe.cloud.service;

import com.bishe.cloud.model.Pi;

import java.util.List;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/10
 * @time: 6:34 下午
 */
public interface PiService {
    int addPi(Pi pi);

    int deletePi(long id);

    int updatePi(Pi pi);

    Pi getPi(long id);

    List<Pi> getAll();
}
