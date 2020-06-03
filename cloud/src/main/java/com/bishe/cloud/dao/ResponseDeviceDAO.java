package com.bishe.cloud.dao;

import com.bishe.cloud.model.ResponseDevice;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/6
 * @time: 8:15 下午
 */
public interface ResponseDeviceDAO extends Mapper<ResponseDevice> {
    @Select({"select url from pi where id=(select pi_id from response_device where id=#{id})"})
    String getUrl(Long id);
}
