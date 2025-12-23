package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RewardRule;
import java.util.List;

public interface RewardRuleRepository extends JpaRepository<RewardRule,Long>{
     List<RewardRule> findByCardId(Long cardId);

    List<RewardRule> findByActiveTrue();
}