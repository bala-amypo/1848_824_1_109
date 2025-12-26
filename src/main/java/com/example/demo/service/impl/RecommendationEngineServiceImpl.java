package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.RecommendationRecord;
import com.example.demo.entity.RewardRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.RecommendationEngineService;

import java.util.List;

public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository purchaseIntentRepository;
    private final UserProfileRepository userProfileRepository;
    private final CreditCardRecordRepository creditCardRepository;
    private final RewardRuleRepository rewardRuleRepository;
    private final RecommendationRecordRepository recommendationRecordRepository;

    // ✅ REQUIRED constructor (USED BY TESTS)
    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository purchaseIntentRepository,
            UserProfileRepository userProfileRepository,
            CreditCardRecordRepository creditCardRepository,
            RewardRuleRepository rewardRuleRepository,
            RecommendationRecordRepository recommendationRecordRepository) {

        this.purchaseIntentRepository = purchaseIntentRepository;
        this.userProfileRepository = userProfileRepository;
        this.creditCardRepository = creditCardRepository;
        this.rewardRuleRepository = rewardRuleRepository;
        this.recommendationRecordRepository = recommendationRecordRepository;
    }

    
@Override
public RecommendationRecord generateRecommendation(Long intentId) {

    PurchaseIntentRecord intent =
            purchaseIntentRepository.findById(intentId).orElse(null);

    if (intent == null) {
        return null;
    }

    List<CreditCardRecord> cards =
            creditCardRepository.findActiveCardsByUser(intent.getUserId());

   
    if (cards == null || cards.isEmpty()) {
        throw new BadRequestException("No active cards found");

    }

    double bestReward = -1;
    Long bestCardId = null;

    for (CreditCardRecord card : cards) {
        List<RewardRule> rules =
                rewardRuleRepository.findActiveRulesForCardCategory(
                        card.getId(),
                        intent.getCategory()
                );

        if (rules == null) continue;

        for (RewardRule rule : rules) {
            double reward = intent.getAmount() * rule.getMultiplier();
            if (reward > bestReward) {
                bestReward = reward;
                bestCardId = card.getId();
            }
        }
    }

    RecommendationRecord rec = new RecommendationRecord();
    rec.setUserId(intent.getUserId());
    rec.setPurchaseIntentId(intentId);
    rec.setRecommendedCardId(bestCardId);
    rec.setExpectedRewardValue(bestReward);
    rec.setCalculationDetailsJson("{\"reward\":" + bestReward + "}");

    return recommendationRecordRepository.save(rec);
}




    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRecordRepository.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRecordRepository.findAll();
    }
}
