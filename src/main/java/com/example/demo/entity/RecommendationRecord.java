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
    public void setRecommendedCardId(Long recommendedCardId){
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
    public void setCalculationDetailsJson(String calculationDetailsJson){
        this.calculationDetailsJson=calculationDetailsJson;
    }

    public LocalDateTime getRecommendedAt(){
        return recommendedAt;
    }
    public void setRecommendedAt(LocalDateTime recommendedAt){
        this.recommentedAt=recommentedAt;
    }

    public RecommendedRecord(Long id,Long purchaseIntentId,Long recommendedCardId,Double expectedRewardValue,String CalculationDetailsJson,LocalDateTime recommendedAt){
        this.id=id;
        this.purchaseIntentId=purchaseIntentId;
        this.recommendedCardId=recommendedCardId;
        this.expectedRewardValue=expectedRewardValue;
        this.merchant=merchant;
        this.intentDate=intentDate;
    }
    public RecommendedRecord(){

    }
    
}