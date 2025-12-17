package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
@Entity
public class UserProfile{
    @Id
    private Long id;
    @Column(unique=true)
    private String userId;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserId(){
        this.userId=userId;
    }
     public String getFullName(){
        return fullName;
    }
    public void setFullName(){
        this.fullName=fullName;
    }
     public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email=email;
    }
     public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password=password;
    }
     public String getRole(){
        return role;
    }
    public void setRole(){
        this.role=role;
    }
     public Boolean getActive(){
        return active;
    }
    public void setActive(){
        this.active=active;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(){
        this.createdAt=createdAt;
    }

    public UserProfile(Long id,String userId,String fullName,String email,String password,String role,Boolean active,LocalDateTime createdAt){
        this.id=id;
        this.userId=userId;
        this.fullName=fullName;
        this.email=email;
        this.password=password;
        this.role=role;
        this.active=active;
        this.createdAt=createdAt;
    }
    public UserProfile(){

    }
}