package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    
    @Autowired
    CreditCardRecordRepository ccr;

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        return ccr.save(card);
    }

    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {
        CreditCardRecord existing =
                ccr.findById(id).orElse(null);

        if (existing != null) {
            existing.setCardName(updated.getCardName());
            existing.setIssuer(updated.getIssuer());
            existing.setCardType(updated.getCardType());
            existing.setAnnualFee(updated.getAnnualFee());
            existing.setStatus(updated.getStatus());
            return ccr.save(existing);
        }
        return null;
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return ccr.findByUserId(userId);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return ccr.findById(id).orElse(null);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return ccr.findAll();
    }
}
