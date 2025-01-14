package com.ty.PresentationApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ty.PresentationApp.dto.RatingRequestDto;
import com.ty.PresentationApp.dto.RatingResponseDto;
import com.ty.PresentationApp.entity.Presentation;
import com.ty.PresentationApp.entity.Rating;
import com.ty.PresentationApp.entity.User;
import com.ty.PresentationApp.exception.PresentationNotFoundException;
import com.ty.PresentationApp.exception.UserNotFoundException;
import com.ty.PresentationApp.repository.PresentationRepository;
import com.ty.PresentationApp.repository.RatingRepository;
import com.ty.PresentationApp.repository.UserRepository;

@Service
public class ratingService {

    private final RatingRepository rRepo;
    private final UserRepository uRepo;
    private final PresentationRepository pRepo;

    public ratingService(RatingRepository rRepo, UserRepository uRepo, PresentationRepository pRepo) {
        this.rRepo = rRepo;
        this.uRepo = uRepo;
        this.pRepo = pRepo;
    }

    public RatingResponseDto ratePresentation(RatingRequestDto request) {
        User user = uRepo.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Presentation presentation = pRepo.findById(request.getPresentationId())
                .orElseThrow(() -> new PresentationNotFoundException("Presentation not found"));

        Rating rating = new Rating();
        BeanUtils.copyProperties(request, rating);
        rating.setUser(user);
        rating.setPresentation(presentation);

        rRepo.save(rating);

        RatingResponseDto response = new RatingResponseDto();
        BeanUtils.copyProperties(rating, response);
        response.setUserId(user.getId());
        response.setPresentationId(presentation.getId());

        return response;
    }

    public List<RatingResponseDto> getRatingsByPresentationId(Integer presentationId) {
        List<Rating> ratings = rRepo.findByPresentation_Id(presentationId);

        return ratings.stream().map(rating -> {
            RatingResponseDto response = new RatingResponseDto();
            BeanUtils.copyProperties(rating, response);
            response.setPresentationId(presentationId);
            response.setUserId(rating.getUser().getId());
            return response;
        }).collect(Collectors.toList());
    }

    public List<RatingResponseDto> getOverallRatingsByUserId(Integer userId) {
        List<Rating> ratings = rRepo.findByUser_Id(userId);

        return ratings.stream().map(rating -> {
            RatingResponseDto response = new RatingResponseDto();
            BeanUtils.copyProperties(rating, response);
            response.setUserId(userId);
            response.setPresentationId(rating.getPresentation().getId());
            return response;
        }).collect(Collectors.toList());
    }
}
