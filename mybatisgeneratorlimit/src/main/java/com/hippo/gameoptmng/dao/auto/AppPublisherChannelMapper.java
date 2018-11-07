package com.hippo.gameoptmng.dao.auto;

import com.hippo.gameoptmng.modal.auto.AppPublisherChannel;
import com.hippo.gameoptmng.modal.auto.AppPublisherChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPublisherChannelMapper {
    int countByExample(AppPublisherChannelExample example);

    int deleteByExample(AppPublisherChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppPublisherChannel record);

    int insertSelective(AppPublisherChannel record);

    List<AppPublisherChannel> selectByExampleWithBLOBs(AppPublisherChannelExample example);

    List<AppPublisherChannel> selectByExample(AppPublisherChannelExample example);

    AppPublisherChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppPublisherChannel record, @Param("example") AppPublisherChannelExample example);

    int updateByExampleWithBLOBs(@Param("record") AppPublisherChannel record, @Param("example") AppPublisherChannelExample example);

    int updateByExample(@Param("record") AppPublisherChannel record, @Param("example") AppPublisherChannelExample example);

    int updateByPrimaryKeySelective(AppPublisherChannel record);

    int updateByPrimaryKeyWithBLOBs(AppPublisherChannel record);

    int updateByPrimaryKey(AppPublisherChannel record);
}