package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CreditCardRecord;
import java.util.List;

public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord,Long>{
    List<CreditCardRecord> findByUserId(Long userId);
}