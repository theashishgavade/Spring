package com.ty.PresentationApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.PresentationApp.dto.RatingRequestDto;
import com.ty.PresentationApp.dto.RatingResponseDto;
import com.ty.PresentationApp.service.ratingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final ratingService rService;

    public RatingController(ratingService rService) {
        this.rService = rService;
    }

    @PostMapping("/rate")
    @ResponseBody
    public ResponseEntity<RatingResponseDto> rate(@RequestBody RatingRequestDto request) {
        RatingResponseDto response = rService.ratePresentation(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/presentation/{presentationId}")
    @ResponseBody
    public ResponseEntity<List<RatingResponseDto>> get(@PathVariable Integer presentationId) {
        List<RatingResponseDto> ratings = rService.getRatingsByPresentationId(presentationId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/student/{userId}")
    @ResponseBody
    public ResponseEntity<List<RatingResponseDto>> getAll(@PathVariable Integer userId) {
        List<RatingResponseDto> ratings = rService.getOverallRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }
}
