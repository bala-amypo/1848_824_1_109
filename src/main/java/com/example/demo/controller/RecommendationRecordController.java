package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationRecordController {

       private final RecommendationEngineService recommendationService;

    public RecommendationController(RecommendationEngineService recommendationService) {
        this.recommendationService = recommendationService;
    }


   
    @PostMapping("/generate/{intentId}")
    public RecommendationRecord generate(@PathVariable Long intentId) {
        return recommendationService.generateRecommendation(intentId);
    }

 
    @GetMapping("/{id}")
    public RecommendationRecord getById(@PathVariable Long id) {
        return recommendationService.getRecommendationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return recommendationService.getRecommendationsByUser(userId);
    }

    @GetMapping
    public List<RecommendationRecord> getAll() {
        return recommendationService.getAllRecommendations();
    }
}
