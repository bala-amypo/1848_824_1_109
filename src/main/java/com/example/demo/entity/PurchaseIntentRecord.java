package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class PurchaseIntentRecord{
    @Id
    private Long id;
    private Long userId;
    private Double amount;
    private String category;
    private String merchant;
    
}