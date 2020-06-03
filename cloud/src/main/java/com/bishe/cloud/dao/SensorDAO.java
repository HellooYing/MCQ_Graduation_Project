package com.bishe.cloud.dao;

import com.bishe.cloud.model.Sensor;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 9:21 下午
 */
public interface SensorDAO extends Mapper<Sensor> {
    @Select({"select url from pi where id=(select pi_id from sensor where id=#{id})"})
    String getUrl(Long id);
}
