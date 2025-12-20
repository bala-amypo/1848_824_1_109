package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;


@Entity
@Table(name = "credit_card_record")
public class CreditCardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Must reference a valid user
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "issuer", nullable = false)
    private String issuer;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    // annualFee must be >= 0
    @Column(name = "annual_fee", nullable = false)
    private Double annualFee;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

   
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (this.annualFee == null || this.annualFee < 0) {
            throw new IllegalArgumentException("Annual fee must be >= 0");
        }
    }

    // 🔹 Constructors
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

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
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
