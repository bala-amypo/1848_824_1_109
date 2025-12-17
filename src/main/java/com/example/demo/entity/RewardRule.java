package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class RewardRule{
    @Id
    private Long id;
    private Long cardId;
    private String category;
    private String rewardType;
    private Double multiplier;
    private Boolean active;

    public Long getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
     public Long getCardId(){
        return cardId;
    }
    public void setCard(){
        this.id=id;
    }

}