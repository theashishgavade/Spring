package com.ty.PresentationApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.PresentationApp.dto.PresentationRequestDto;
import com.ty.PresentationApp.dto.PresentationResponseDto;
import com.ty.PresentationApp.enums.PresentationStatus;
import com.ty.PresentationApp.service.presentationService;

@RestController
@RequestMapping("/presentation")
public class PresentationController {

    private presentationService pService;

    public PresentationController(presentationService pService) {
        this.pService = pService;
    }

    @PostMapping("/assign")
    @ResponseBody
    public ResponseEntity<PresentationResponseDto> assign(@RequestBody PresentationRequestDto request) {
        PresentationResponseDto response = pService.assignPresentation(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{presentationId}")
    @ResponseBody
    public ResponseEntity<PresentationResponseDto> get(@PathVariable Integer presentationId) {
        PresentationResponseDto response = pService.getPresentationById(presentationId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/student/{userId}")
    @ResponseBody
    public ResponseEntity<List<PresentationResponseDto>> getAll(@PathVariable Integer userId) {
        List<PresentationResponseDto> presentations = pService.getPresentationsByUserId(userId);
        return ResponseEntity.ok(presentations);
    }

    @PutMapping("/{presentationId}/status")
    @ResponseBody
    public ResponseEntity<String> changeStatus(@PathVariable Integer presentationId, 
                                               @RequestParam PresentationStatus status) {
        pService.changePresentationStatus(presentationId, status);
        return ResponseEntity.ok("Presentation status updated successfully");
    }

    @PutMapping("/{presentationId}/score")
    @ResponseBody
    public ResponseEntity<String> score(@PathVariable Integer presentationId, @RequestParam Double score) {
        pService.savePresentationScore(presentationId, score);
        return ResponseEntity.ok("Presentation score saved successfully");
    }
}
