package org.springeel.oneclickrecipe.domain.review.service;

import org.springeel.oneclickrecipe.domain.review.dto.service.ReviewCreateServiceRequestDto;
import org.springeel.oneclickrecipe.domain.review.dto.service.ReviewUpdateServiceRequestDto;
import org.springeel.oneclickrecipe.domain.user.entity.User;

public interface ReviewService {
    void createReview(User user, ReviewCreateServiceRequestDto controllerRequestDto, Long recipeId);

    void updateReview(Long reviewId, User user, ReviewUpdateServiceRequestDto serviceRequestDto);

    void deleteReview(User user, Long reviewId);
}
