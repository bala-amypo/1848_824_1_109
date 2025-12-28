package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "credit_card_record")
public class CreditCardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // @ManyToOne(optional = false)

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String issuer;
   // private Long userId;

    private String cardType;

    @Min(0)
    @Column(nullable = false)
    private Double annualFee;

    private String status;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    @ManyToMany(mappedBy = "favouriteCards")
    private Set<UserProfile> favouredByUsers;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public CreditCardRecord() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
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

    public Set<UserProfile> getFavouredByUsers() {
        return favouredByUsers;
    }

    public Long getUserId() {
    return userId;
}

public void setUserId(Long userId) {
    this.userId = userId;
}


    

    public CreditCardRecord(Long id, String cardName,
                            String issuer, String cardType,
                            Double annualFee, String status,
                            LocalDateTime createdAt) {
        this.id = id;
       
        this.cardName = cardName;
        this.issuer = issuer;
        this.cardType = cardType;
        this.annualFee = annualFee;
        this.status = status;
        this.createdAt = createdAt;
    }

}