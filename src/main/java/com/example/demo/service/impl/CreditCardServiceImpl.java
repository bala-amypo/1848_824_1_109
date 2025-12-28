package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository creditCardRepository;

    
    public CreditCardServiceImpl(
            CreditCardRecordRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

@Override
public CreditCardRecord addCard(Long userId, CreditCardRecord card) {
    card.setUserId(userId);
    return creditCardRepository.save(card);
}

@Override
public CreditCardRecord addCard(CreditCardRecord card) {
   
    return creditCardRepository.save(card);
}



    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {

        CreditCardRecord existing =
                creditCardRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCardName(updated.getCardName());
            existing.setIssuer(updated.getIssuer());
            existing.setCardType(updated.getCardType());
            existing.setAnnualFee(updated.getAnnualFee());
            existing.setStatus(updated.getStatus());
            return creditCardRepository.save(existing);
        }
        return null;
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return creditCardRepository.findByUserId(userId);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return creditCardRepository.findById(id).orElse(null);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return creditCardRepository.findAll();
    }
}

// package com.example.demo.service.impl;

// import com.example.demo.entity.CreditCardRecord;
// import com.example.demo.entity.UserProfile;
// import com.example.demo.repository.CreditCardRecordRepository;
// import com.example.demo.repository.UserProfileRepository;
// import com.example.demo.service.CreditCardService;

// import java.util.List;

// import org.springframework.stereotype.Service;

// @Service
// public class CreditCardServiceImpl implements CreditCardService {

//     private final CreditCardRecordRepository creditCardRepository;
//     private final UserProfileRepository userProfileRepository;

//     public CreditCardServiceImpl(
//             CreditCardRecordRepository creditCardRepository,
//             UserProfileRepository userProfileRepository) {
//         this.creditCardRepository = creditCardRepository;
//         this.userProfileRepository = userProfileRepository;
//     }

//     @Override
//     public CreditCardRecord addCard(Long userId, CreditCardRecord card) {

//         UserProfile user = userProfileRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         card.setUser(user);   // ✅ correct mapping
//         return creditCardRepository.save(card);
//     }

//     @Override
//     public CreditCardRecord addCard(CreditCardRecord card) {
//         return creditCardRepository.save(card);
//     }

//     @Override
//     public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {

//         CreditCardRecord existing =
//                 creditCardRepository.findById(id).orElse(null);

//         if (existing != null) {
//             existing.setCardName(updated.getCardName());
//             existing.setIssuer(updated.getIssuer());
//             existing.setCardType(updated.getCardType());
//             existing.setAnnualFee(updated.getAnnualFee());
//             existing.setStatus(updated.getStatus());
//             return creditCardRepository.save(existing);
//         }
//         return null;
//     }

//     @Override
//     public List<CreditCardRecord> getCardsByUser(Long userId) {
//         // ✅ property traversal (UserProfile.id)
//         return creditCardRepository.findByUser_Id(userId);
//     }

//     @Override
//     public CreditCardRecord getCardById(Long id) {
//         return creditCardRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<CreditCardRecord> getAllCards() {
//         return creditCardRepository.findAll();
//     }
// }
