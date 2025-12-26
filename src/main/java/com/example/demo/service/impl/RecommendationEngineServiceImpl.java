package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.entity.RecommendationRecord;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.repository.RecommendationRecordRepository;
import com.example.demo.service.RecommendationEngineService;

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    @Autowired
    private PurchaseIntentRecordRepository purchaseIntentRepo;

    @Autowired
    private RecommendationRecordRepository recommendationRepo;

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {

        // 1️⃣ Fetch intent
        PurchaseIntentRecord intent =
                purchaseIntentRepo.findById(intentId).orElse(null);

        if (intent == null) {
            return null;
        }

        // 2️⃣ Fetch active cards for user
        // (Simplified – normally query by userId & active status)
        Long recommendedCardId = 1L; // dummy card id

        // 3️⃣ Fetch active rules (simplified)
        // 4️⃣ Calculate reward
        Double reward = intent.getAmount() * 0.05; // 5% reward example

        // 5️⃣ Save recommendation
        RecommendationRecord rec = new RecommendationRecord();
        rec.setPurchaseIntentId(intentId);
        rec.setRecommendedCardId(recommendedCardId);
        rec.setExpectedRewardValue(reward);
        rec.setCalculationDetailsJson("{\"rate\":5}");
        
        return recommendationRepo.save(rec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRepo.findById(id).orElse(null);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRepo.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRepo.findAll();
    }
}


// public RecommendationEngineServiceImpl(
//         PurchaseIntentRecordRepository purchaseIntentRepository,
//         UserProfileRepository userProfileRepository,
//         CreditCardRecordRepository creditCardRepository,
//         RewardRuleRepository rewardRuleRepository,
//         RecommendationRecordRepository recommendationRecordRepository) {

//     this.purchaseIntentRepository = purchaseIntentRepository;
//     this.userProfileRepository = userProfileRepository;
//     this.creditCardRepository = creditCardRepository;
//     this.rewardRuleRepository = rewardRuleRepository;
//     this.recommendationRecordRepository = recommendationRecordRepository;
// }
