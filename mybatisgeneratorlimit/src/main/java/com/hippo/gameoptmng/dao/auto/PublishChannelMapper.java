package com.hippo.gameoptmng.dao.auto;

import com.hippo.gameoptmng.modal.auto.PublishChannel;
import com.hippo.gameoptmng.modal.auto.PublishChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishChannelMapper {
    int countByExample(PublishChannelExample example);

    int deleteByExample(PublishChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublishChannel record);

    int insertSelective(PublishChannel record);

    List<PublishChannel> selectByExample(PublishChannelExample example);

    PublishChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PublishChannel record, @Param("example") PublishChannelExample example);

    int updateByExample(@Param("record") PublishChannel record, @Param("example") PublishChannelExample example);

    int updateByPrimaryKeySelective(PublishChannel record);

    int updateByPrimaryKey(PublishChannel record);
}