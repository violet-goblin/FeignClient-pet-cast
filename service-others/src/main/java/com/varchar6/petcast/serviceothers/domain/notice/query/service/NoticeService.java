package com.varchar6.petcast.serviceothers.domain.notice.query.service;

import com.varchar6.petcast.serviceothers.domain.notice.query.dto.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    NoticeDTO getNoticeById(int memberId);
//    List<NoticeDTO> getAllNotices();
    Page<Map<String, Object>> getAllNotices(NoticeDTO noticeDTO, Pageable pageable);

}
