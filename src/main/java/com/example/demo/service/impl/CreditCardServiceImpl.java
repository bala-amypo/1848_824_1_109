package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

 @Autowired
 CreditCardRecordRepository ccr;

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        return ccr.save(card);
    }
}