package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.repository.PurchaseIntentRecordRepository;
import com.example.demo.service.PurchaseIntentService;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    @Autowired
    private PurchaseIntentRecordRepository repository;

    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) {
       
        if (intent.getAmount() == null || intent.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        return repository.save(intent);
    }

    @Override
    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public PurchaseIntentRecord getIntentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseIntentRecord> getAllIntents() {
        return repository.findAll();
    }
}
