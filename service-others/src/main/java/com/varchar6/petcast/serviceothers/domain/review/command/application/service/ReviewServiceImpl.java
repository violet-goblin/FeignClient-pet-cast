package com.varchar6.petcast.serviceothers.domain.review.command.application.service;

import com.varchar6.petcast.serviceothers.domain.event.command.domain.aggregate.EventStatusEnum;
import com.varchar6.petcast.serviceothers.domain.event.query.dto.EventDTO;
import com.varchar6.petcast.serviceothers.domain.event.query.service.EventService;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.request.ReviewCreateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.request.ReviewUpdateRequestDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.application.dto.response.ReviewResponseDTO;
import com.varchar6.petcast.serviceothers.domain.review.command.domain.aggregate.entity.Review;
import com.varchar6.petcast.serviceothers.domain.review.command.domain.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service(value = "commandReviewService")
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    private final EventService eventService;


    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper, EventService eventService) {
        this.reviewRepository = reviewRepository;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.modelMapper = modelMapper;
        this.eventService = eventService;
    }

    @Override
    @Transactional
    public int insertReview(ReviewCreateRequestDTO reviewCreateRequestDTO) {
        int result = 0;

        EventDTO eventDTO = eventService.findEvent(reviewCreateRequestDTO.getEventId());

        if(eventDTO.getStatus() == EventStatusEnum.DONE) {
            Review review = modelMapper.map(reviewCreateRequestDTO, Review.class);
            reviewRepository.save(review);
            result++;
            return result;
        }
        else
            return result;

    }

    @Override
    @Transactional
    public ReviewResponseDTO updateReview(ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        Review review = reviewRepository.findById(reviewUpdateRequestDTO.getId()).orElse(null);

        if (review == null)
            throw new IllegalArgumentException("Review not found with id: " + reviewUpdateRequestDTO.getId());

        if (reviewUpdateRequestDTO.getComment() != null && !reviewUpdateRequestDTO.getComment().isEmpty())
            review.setComment(reviewUpdateRequestDTO.getComment());

        if (reviewUpdateRequestDTO.getTitle() != null && !reviewUpdateRequestDTO.getTitle().isEmpty())
            review.setTitle(reviewUpdateRequestDTO.getTitle());

        if (reviewUpdateRequestDTO.getScore() != null)
            review.setScore(reviewUpdateRequestDTO.getScore());

        reviewRepository.save(review);

        ReviewResponseDTO responseDTO = modelMapper.map(review, ReviewResponseDTO.class);

        return responseDTO;
    }

    @Override
    @Transactional
    public void deleteReview(int id) {

        reviewRepository.deleteById(id);
    }
}
