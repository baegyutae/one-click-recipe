package org.springeel.oneclickrecipe.domain.review.dto.service;

public record ReviewCreateServiceRequestDto(
    String content,
    Byte star
) {

}

