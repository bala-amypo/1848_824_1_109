package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CreditCardRecord;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord,Long>{
    List<CreditCardRecord> findByUser_Id(Long userId);
     @Query("SELECT c FROM CreditCardRecord c " +
           "WHERE c.userId = :userId AND c.status = 'ACTIVE'")
    List<CreditCardRecord> findActiveCardsByUser(Long userId);
}