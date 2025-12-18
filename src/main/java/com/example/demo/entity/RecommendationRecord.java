package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@Entity
public class RecommendationRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private Double expectedRewardValue;
    private String calculationDetailsJson;
    
    private LocalDateTime recommendedAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getPurchaseIntentId(){
        return purchaseIntentId;
    }
    public void setPurchaseIntentId(Long purchaseIntentId){
        this.purchaseIntentId;
    }
    public Long getRecommendedCardId(){
        return recommendedCardId;
    }
    public void setAmount(Long recommendedCardId){
        this.recommendedCardId=recommendedCardId;
    }
    public Double getExpectedRewardValue(){
        return expectedRewardValue;
    }
    public void setExpectedRewardValue(Double expectedRewardValue){
        this.expectedRewardValue=expectedRewardValue;
    }
    public String getCalculationDetailsJson(){
        return calculationDetailsJson;
    }
    public void setCalculationDetailsJson(String ){
        this.merchant=merchant;
    }
    public LocalDateTime getIntentDate(){
        return intentDate;
    }
    public void setIntentDate(LocalDateTime intentDate){
        this.intentDate=intentDate;
    }

    public PurchaseIntentRecord(Long id,Long userId,Double amount,String category,String Merchant,LocalDateTime intentDate){
        this.id=id;
        this.userId=userId;
        this.amount=amount;
        this.category=category;
        this.merchant=merchant;
        this.intentDate=intentDate;
    }
    public PurchaseIntentRecord(){

    }
    
}