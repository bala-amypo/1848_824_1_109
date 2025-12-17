package com.example.demo.entity;
import.jakarta.perisistance.Entity;
@Entity
public class CreditCardRecord{
    private Long id;
    private Long userId;
    private String cardName;
    private String issuer;
    private String cardType;
    private Double annualFee;
    private String status;
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId=userId;
    }
    public String getCardName(){
        return cardName;
    }
    
}