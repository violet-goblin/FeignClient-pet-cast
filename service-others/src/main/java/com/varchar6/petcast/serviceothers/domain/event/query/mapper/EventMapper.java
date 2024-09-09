package com.varchar6.petcast.serviceothers.domain.event.query.mapper;

import com.varchar6.petcast.serviceothers.domain.event.query.dto.EventDTO;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.springframework.data.repository.query.Param;

@Mapper
public interface EventMapper {

    List<EventDTO> selectEventByCustomerId(Map<String, String> params);

    List<EventDTO> selectEventByCompanyId(Map<String, String> params);

    EventDTO selectEventById(Integer eventId);
}
