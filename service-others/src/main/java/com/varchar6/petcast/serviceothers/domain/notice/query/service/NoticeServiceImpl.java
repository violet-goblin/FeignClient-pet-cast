package com.varchar6.petcast.serviceothers.domain.notice.query.service;

import com.varchar6.petcast.serviceothers.common.util.RequestList;
import com.varchar6.petcast.serviceothers.domain.notice.query.dto.NoticeDTO;
import com.varchar6.petcast.serviceothers.domain.notice.query.mapper.NoticeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service(value="queryNoticeService")
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

    @Autowired
    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    @Transactional
    public NoticeDTO getNoticeById(int memberId) {
        return noticeMapper.selectNoticeByNoticeId(memberId);
    }

    @Override
    @Transactional
    public Page<Map<String, Object>> getAllNotices(NoticeDTO noticeDTO, Pageable pageable) {
        /* 설명. 빌더 패턴으로 data, pageable 파라미터에 데이터 주입 */
        RequestList<?> requestList = RequestList.builder()
                .data(noticeDTO)
                .pageable(pageable)
                .build();

        List<Map<String, Object>> content = noticeMapper.selectAllNotice(requestList);
        int total = noticeMapper.selectAllNoticeCount();

        return new PageImpl<>(content, pageable, total);
//        return noticeMapper.selectAllNotice();
    }
}
