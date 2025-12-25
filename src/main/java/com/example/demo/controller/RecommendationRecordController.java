package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationRecordController {

    @Autowired
    private RecommendationEngineService recommendationService;

    // Generate recommendation
    @PostMapping("/generate/{intentId}")
    public RecommendationRecord generate(@PathVariable Long intentId) {
        return recommendationService.generateRecommendation(intentId);
    }

    // Get by recommendation id
    @GetMapping("/{id}")
    public RecommendationRecord getById(@PathVariable Long id) {
        return recommendationService.getRecommendationById(id);
    }

    // Get by user id
    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return recommendationService.getRecommendationsByUser(userId);
    }

    // Get all recommendations
    @GetMapping
    public List<RecommendationRecord> getAll() {
        return recommendationService.getAllRecommendations();
    }
}
