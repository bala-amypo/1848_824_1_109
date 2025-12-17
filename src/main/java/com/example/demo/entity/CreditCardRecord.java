package com.example.demo.entity;
import.jakarta.perisistance.Entity;
@Entity
public class CreditCardRecord{
    private long id;
    private long userId;
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
    
}