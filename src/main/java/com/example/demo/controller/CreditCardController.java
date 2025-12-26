package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

   private final CreditCardService creditCardService;

    // ✅ REQUIRED by automated tests
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


  
    @PostMapping
    public CreditCardRecord addCard(
            @PathVariable Long userId,
            @RequestBody CreditCardRecord card) {
        return creditCardService.addCard(userId, card);
    }

 
    @PutMapping("/{id}")
    public CreditCardRecord updateCard(
            @PathVariable Long id,
            @RequestBody CreditCardRecord card) {
        return creditCardService.updateCard(id, card);
    }


    @GetMapping("/{id}")
    public CreditCardRecord getCardById(@PathVariable Long id) {
        return creditCardService.getCardById(id);
    }

    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        return creditCardService.getCardsByUser(userId);
    }

    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return creditCardService.getAllCards();
    }
}

// package com.example.demo.controller;

// import com.example.demo.service.CreditCardService;

// public class CreditCardRecordController {

//     private final CreditCardService service;

//     public CreditCardRecordController(CreditCardService service) {
//         this.service = service;
//     }
// }

