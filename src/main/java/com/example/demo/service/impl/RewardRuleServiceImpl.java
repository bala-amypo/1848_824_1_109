package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

import java.util.List;

public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository rewardRuleRepository;

    // ✅ REQUIRED constructor (used by tests)
    public RewardRuleServiceImpl(RewardRuleRepository rewardRuleRepository) {
        this.rewardRuleRepository = rewardRuleRepository;
    }

    @Override
    public RewardRule createRule(RewardRule rule) {

        if (rule.getMultiplier() == null || rule.getMultiplier() <= 0) {
            // ✅ Test expects BadRequestException
            throw new BadRequestException("Price multiplier must be > 0");
        }

        return rewardRuleRepository.save(rule);
    }

    @Override
    public RewardRule updateRule(Long id, RewardRule updated) {

        RewardRule existing =
                rewardRuleRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        if (updated.getMultiplier() == null || updated.getMultiplier() <= 0) {
            // ✅ Same message expected by tests
            throw new BadRequestException("Price multiplier must be > 0");
        }

        existing.setMultiplier(updated.getMultiplier());
        existing.setActive(updated.getActive());
        existing.setCategory(updated.getCategory());
        existing.setRewardType(updated.getRewardType());

        return rewardRuleRepository.save(existing);
    }

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return rewardRuleRepository.findByCardId(cardId);
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return rewardRuleRepository.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return rewardRuleRepository.findAll();
    }
}
