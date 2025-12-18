package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class PurchaseIntentRecord{
    @Id
    @GeneratedValue(strategy=GeneratedType.IDENTITY)
    private Long id;
    private Long userId;
    private Double amount;
    private String category;
    private String merchant;

}