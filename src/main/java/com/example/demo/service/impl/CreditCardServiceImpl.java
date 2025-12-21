package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository ccr;
    private final UserProfileRepository userRepo;


    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {

        // Rule 1: annualFee ≥ 0
        if (card.getAnnualFee() == null || card.getAnnualFee() < 0) {
            throw new IllegalArgumentException("Annual fee must be >= 0");
        }

        // Rule 2: must reference valid user
        if (!userRepo.existsById(card.getUserId())) {
            throw new RuntimeException("User does not exist with id: " + card.getUserId());
        }

        return ccr.save(card);
    }

    // ---------------- UPDATE CARD ----------------
    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {

        CreditCardRecord existing = ccr.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: " + id));

        if (updated.getAnnualFee() != null && updated.getAnnualFee() < 0) {
            throw new IllegalArgumentException("Annual fee must be >= 0");
        }

        existing.setCardName(updated.getCardName());
        existing.setIssuer(updated.getIssuer());
        existing.setCardType(updated.getCardType());
        existing.setAnnualFee(updated.getAnnualFee());
        existing.setStatus(updated.getStatus());

        return ccr.save(existing);
    }

    // ---------------- GET BY USER ----------------
    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {

        if (!userRepo.existsById(userId)) {
            throw new RuntimeException("User does not exist with id: " + userId);
        }

        return ccr.findByUserId(userId);
    }

    // ---------------- GET BY CARD ID ----------------
    @Override
    public CreditCardRecord getCardById(Long id) {
        return ccr.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: " + id));
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<CreditCardRecord> getAllCards() {
        return ccr.findAll();
    }
}
