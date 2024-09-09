package com.varchar6.petcast.serviceothers.domain.notice.query.service;

import com.varchar6.petcast.serviceothers.domain.notice.query.dto.NoticeDTO;

import java.util.List;

public interface NoticeService {

    NoticeDTO getNoticeById(int memberId);
    List<NoticeDTO> getAllNotices();
}
