package com.ty.PresentationApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ty.PresentationApp.dto.PresentationRequestDto;
import com.ty.PresentationApp.dto.PresentationResponseDto;
import com.ty.PresentationApp.entity.Presentation;
import com.ty.PresentationApp.entity.User;
import com.ty.PresentationApp.enums.PresentationStatus;
import com.ty.PresentationApp.exception.PresentationNotFoundException;
import com.ty.PresentationApp.exception.UserNotFoundException;
import com.ty.PresentationApp.repository.PresentationRepository;
import com.ty.PresentationApp.repository.UserRepository;

@Service
public class presentationService {

    private PresentationRepository pRepo;
    private UserRepository uRepo;

    public presentationService(PresentationRepository pRepo, UserRepository uRepo) {
        this.pRepo = pRepo;
        this.uRepo = uRepo;
    }

    public PresentationResponseDto assignPresentation(PresentationRequestDto request) {
        User user = uRepo.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Presentation presentation = new Presentation();
        BeanUtils.copyProperties(request, presentation);
        presentation.setUser(user);
        presentation.setPresentationStatus(PresentationStatus.ASSIGNED);

        pRepo.save(presentation);

        PresentationResponseDto response = new PresentationResponseDto();
        BeanUtils.copyProperties(presentation, response);
        response.setUserId(user.getId());

        return response;
    }

    public PresentationResponseDto getPresentationById(Integer presentationId) {
        Presentation presentation = pRepo.findById(presentationId)
                .orElseThrow(() -> new PresentationNotFoundException("Presentation not found"));

        PresentationResponseDto response = new PresentationResponseDto();
        BeanUtils.copyProperties(presentation, response);
        response.setUserId(presentation.getUser().getId());

        return response;
    }

    public List<PresentationResponseDto> getPresentationsByUserId(Integer userId) {
        List<Presentation> presentations = pRepo.findByUser_Id(userId);

        return presentations.stream().map(presentation -> {
            PresentationResponseDto response = new PresentationResponseDto();
            BeanUtils.copyProperties(presentation, response);
            response.setUserId(userId);
            return response;
        }).collect(Collectors.toList());
    }

    public void changePresentationStatus(Integer presentationId, PresentationStatus status) {
        Presentation presentation = pRepo.findById(presentationId)
                .orElseThrow(() -> new PresentationNotFoundException("Presentation not found"));

        presentation.setPresentationStatus(status);
        pRepo.save(presentation);
    }

    public void savePresentationScore(Integer presentationId, Double score) {
        Presentation presentation = pRepo.findById(presentationId)
                .orElseThrow(() -> new PresentationNotFoundException("Presentation not found"));

        presentation.setUserTotalScore(score);
        pRepo.save(presentation);
    }
}
