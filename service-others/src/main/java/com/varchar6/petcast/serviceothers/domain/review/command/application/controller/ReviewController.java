package com.varchar6.petcast.serviceothers.domain.review.command.application.controller;

import com.varchar6.petcast.serviceothers.common.response.ResponseMessage;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.request.ReviewCreateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.request.ReviewUpdateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.response.ReviewResponseDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.application.service.ReviewService;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "commandReviewController")
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("")
    private ResponseEntity<ResponseMessage> createReview(@RequestBody ReviewCreateRequestDTO reviewCreateRequestDTO){

        int result = reviewService.insertReview(reviewCreateRequestDTO);

        if(result == 1)
            return ResponseEntity
                .ok()
                .body(
                    ResponseMessage.builder()
                        .httpStatus(HttpStatus.CREATED.value())
                        .message("리뷰 생성 성공")
                        .result(null)
                        .build()
                );

        else
            return ResponseEntity
                .ok()
                .body(
                    ResponseMessage.builder()
                        .httpStatus(HttpStatus.NO_CONTENT.value())
                        .message("리뷰 생성 실패. 이벤트 상태가 완료되지 않았습니다")
                        .result(null)
                        .build()
                );
    }

    @PutMapping("")
    private ResponseEntity<ResponseMessage> updateReview(@RequestBody ReviewUpdateRequestDTO reviewUpdateRequestDTO){

        ReviewResponseDTO responseDTO = reviewService.updateReview(reviewUpdateRequestDTO);

        return ResponseEntity
            .ok()
            .body(
                ResponseMessage.builder()
                    .httpStatus(HttpStatus.CREATED.value())
                    .message("리뷰 수정 성공")
                    .result(responseDTO)
                    .build()
            );
    }

    @DeleteMapping("")
    private ResponseEntity<ResponseMessage> deleteReview(@RequestBody Map<String, Integer> request){
        int id = request.get("id");
        reviewService.deleteReview(id);

        return ResponseEntity
            .ok()
            .body(
                ResponseMessage.builder()
                    .httpStatus(HttpStatus.OK.value())
                    .message("리뷰 삭제 성공")
                    .result(null)
                    .build()
            );
    }

}
