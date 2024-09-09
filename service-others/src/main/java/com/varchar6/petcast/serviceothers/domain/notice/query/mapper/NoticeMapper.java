package com.varchar6.petcast.serviceothers.domain.notice.query.mapper;

import com.varchar6.petcast.serviceothers.domain.notice.query.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> selectAllNotice();
    NoticeDTO selectNoticeByNoticeId(int noticeId);
}
