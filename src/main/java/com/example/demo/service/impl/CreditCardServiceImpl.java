package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    

    @Autowired
    private UserProfileRepository userRepo;

    @Override
    public CreditCardRecord addCard(Long userId, CreditCardRecord card) {
        UserProfile user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        card.setUser(user);
        return cardRepo.save(card);
    }

    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {
        CreditCardRecord existing = cardRepo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setCardName(updated.getCardName());
        existing.setIssuer(updated.getIssuer());
        existing.setCardType(updated.getCardType());
        existing.setAnnualFee(updated.getAnnualFee());
        existing.setStatus(updated.getStatus());

        return cardRepo.save(existing);
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return cardRepo.findByUserId(userId);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return cardRepo.findById(id).orElse(null);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return cardRepo.findAll();
    }
}

// public CreditCardServiceImpl(
//         CreditCardRecordRepository creditCardRepository) {
//     this.creditCardRepository = creditCardRepository;
// }
