package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.util.Set;
import jakarta.validation.constraints.Min;

@Entity
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserProfile userId;
    private String cardName;
    private String issuer;
    private String cardType;
    @Min(0)
    private Double annualFee;
    private String status;
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "favouriteCards")
    private Set<UserProfile> favouredByUsers;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public CreditCardRecord() {}

    public CreditCardRecord(Long id, Long userId, String cardName,
                            String issuer, String cardType,
                            Double annualFee, String status,
                            LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.cardName = cardName;
        this.issuer = issuer;
        this.cardType = cardType;
        this.annualFee = annualFee;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
        }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(Double annualFee) {
        this.annualFee = annualFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
