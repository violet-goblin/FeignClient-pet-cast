package com.varchar6.petcast.serviceothers.domain.notice.command.application.controller;

import com.varchar6.petcast.serviceothers.common.response.ResponseMessage;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.request.NoticeUpdateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.request.NoticeWriteRequestDTO;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.response.NoticeResponseDTO;
import com.varchar6.petcast.serviceothers.domain.notice.command.application.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController(value = "commandNoticeController")
@RequestMapping("/api/v1/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("")
    private ResponseEntity<ResponseMessage> createNotice(@RequestBody NoticeWriteRequestDTO noticeWriteRequestDTO,
                                                         @RequestHeader("X-Member-Id") String id) throws IllegalAccessException {
        noticeWriteRequestDTO.setMemberId(id);
        int result = noticeService.insertNotice(noticeWriteRequestDTO);

        return ResponseEntity
                .ok()
                .body(
                        ResponseMessage.builder()
                                .httpStatus(HttpStatus.OK.value())
                                .message("공지 생성 성공")
                                .result(true)
                                .build()
                );
    }

    @PutMapping("")
    private ResponseEntity<ResponseMessage> updateNotice(@RequestBody NoticeUpdateRequestDTO noticeUpdateRequestDTO,
                                                        @RequestAttribute("memberId") int memberId) throws IllegalAccessException{

        noticeUpdateRequestDTO.setMemberId(memberId);
        int result = noticeService.updateNotice(noticeUpdateRequestDTO);

        return ResponseEntity
                .ok()
                .body(
                        ResponseMessage.builder()
                                .httpStatus(HttpStatus.OK.value())
                                .message("공지 중요도 수정 성공")
                                .result(true)
                                .build()
                );
    }

    @DeleteMapping("")
    private ResponseEntity<ResponseMessage> deleteNotice(@RequestBody Map<String, Integer> request
                                                    , @RequestAttribute("memberId") int memberId) throws IllegalAccessException{
        int id = request.get("id");
        int result = noticeService.deleteNotice(id, memberId);

        return ResponseEntity
                .ok()
                .body(
                        ResponseMessage.builder()
                                .httpStatus(HttpStatus.OK.value())
                                .message("공지 삭제 성공")
                                .result(true)
                                .build()
                );
    }
}
