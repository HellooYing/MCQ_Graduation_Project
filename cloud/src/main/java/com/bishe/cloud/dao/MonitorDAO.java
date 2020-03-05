package com.bishe.cloud.dao;

import com.bishe.cloud.model.Monitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 8:14 下午
 */
public interface MonitorDAO extends Mapper<Monitor> {
    @Select({"select url from pi where id=(select pi_id from monitor join sensor on monitor.sensor_id=sensor.id where monitor.id=#{id})"})
    String getUrl(Long id);
}
