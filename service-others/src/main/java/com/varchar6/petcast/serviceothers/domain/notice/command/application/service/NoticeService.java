package com.varchar6.petcast.serviceothers.domain.notice.command.application.service;

import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.request.NoticeUpdateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.request.NoticeWriteRequestDTO;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.response.NoticeResponseDTO;

import java.util.List;


public interface NoticeService {
    int insertNotice(NoticeWriteRequestDTO noticeWriteRequestDTO) throws IllegalAccessException;
    int updateNotice(NoticeUpdateRequestDTO noticeUpdateRequestDTO) throws IllegalAccessException;
    int deleteNotice(int noticeId, String memberId) throws IllegalAccessException;

}
