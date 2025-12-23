package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;

@RestController
@RequestMapping("/api/reward-rules")
public class RewardRuleController {

    @Autowired
    private RewardRuleService rewardRuleService;

    // ➕ Create reward rule
    @PostMapping
    public RewardRule createRule(@RequestBody RewardRule rule) {
        return rewardRuleService.createRule(rule);
    }

    // ✏ Update reward rule
    @PutMapping("/{id}")
    public RewardRule updateRule(
            @PathVariable Long id,
            @RequestBody RewardRule rule) {
        return rewardRuleService.updateRule(id, rule);
    }

    // 💳 Get rules by card
    @GetMapping("/card/{cardId}")
    public List<RewardRule> getRulesByCard(@PathVariable Long cardId) {
        return rewardRuleService.getRulesByCard(cardId);
    }

    // ✅ Get active rules
    @GetMapping("/active")
    public List<RewardRule> getActiveRules() {
        return rewardRuleService.getActiveRules();
    }

    // 📄 Get all rules
    @GetMapping
    public List<RewardRule> getAllRules() {
        return rewardRuleService.getAllRules();
    }
}
