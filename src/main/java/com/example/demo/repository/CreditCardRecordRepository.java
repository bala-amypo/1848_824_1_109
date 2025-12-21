package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CreditCardRecord;


public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord,Long>{
   
}