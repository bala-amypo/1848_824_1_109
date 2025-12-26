package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(
    name = "reward_rule",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"card_id", "category"})
    }
)
public class RewardRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id")
    private CreditCardRecord card;
    private Long cardId;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String rewardType;

    @Min(1) 
    @Column(nullable = false)
    private Double multiplier;

    @Column(nullable = false)
    private Boolean active;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCardRecord getCard() {
        return card;
    }

    public void setCard(CreditCardRecord card) {
        this.card = card;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public Long getCardId() {
    return cardId;
}

public void setCardId(Long cardId) {
    this.cardId = cardId;
}



public RewardRule(CreditCardRecord card,
                  String category,
                  String rewardType,
                  Double multiplier,
                  Boolean active) {
    this.card = card;
    this.category = category;
    this.rewardType = rewardType;
    this.multiplier = multiplier;
    this.active = active;
}

    public RewardRule(){
        
    }
}