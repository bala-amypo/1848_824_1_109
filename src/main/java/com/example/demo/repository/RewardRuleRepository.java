package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RewardRule;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface RewardRuleRepository extends JpaRepository<RewardRule,Long>{
     List<RewardRule> findByCardId(Long cardId);

    List<RewardRule> findByActiveTrue();
     @Query("""
        SELECT r FROM RewardRule r
        WHERE r.cardId = :cardId
        AND r.category = :category
        AND r.active = true
    """)
    List<RewardRule> findActiveRulesForCardCategory(
            Long cardId, String category); // ✅ REQUIRED
}