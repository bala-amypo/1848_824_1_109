package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.RewardRule;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    @Autowired
    private RewardRuleRepository ruleRepo;

    @Autowired
    private CreditCardRecordRepository cardRepo;

    @Override
    public RewardRule createRule(RewardRule rule) {
        
        if (rule.getMultiplier() == null || rule.getMultiplier() <= 0) {
            throw new IllegalArgumentException("Multiplier must be greater than 0");
        }

        return ruleRepo.save(rule);
    }

@Override
public RewardRule updateRule(Long id, RewardRule updated) {
    RewardRule existing = ruleRepo.findById(id).orElse(null);
    if (existing == null) {
        return null;
    }

    if (updated.getMultiplier() != null && updated.getMultiplier() > 0) {
        existing.setMultiplier(updated.getMultiplier());
    } else {
        throw new IllegalArgumentException("Multiplier must be greater than 0");
    }

    existing.setActive(updated.getActive());
    existing.setCategory(updated.getCategory());
    existing.setRewardType(updated.getRewardType());

    return ruleRepo.save(existing);
}

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return ruleRepo.findByCardId(cardId);
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return ruleRepo.findAll();
    }
}

// public RewardRuleServiceImpl(
//         RewardRuleRepository rewardRuleRepository) {
//     this.rewardRuleRepository = rewardRuleRepository;
// }
