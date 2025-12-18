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
    private LocalDateTime intentDate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getUserId()
}