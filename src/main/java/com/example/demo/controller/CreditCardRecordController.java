package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    // Add new card
    @PostMapping
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return creditCardService.addCard(card);
    }

    // Update card
    @PutMapping("/{id}")
    public CreditCardRecord updateCard(
            @PathVariable Long id,
            @RequestBody CreditCardRecord updated) {

        return creditCardService.updateCard(id, updated);
    }

    // Get card by ID
    @GetMapping("/{id}")
    public CreditCardRecord getCardById(@PathVariable Long id) {
        return creditCardService.getCardById(id);
    }

    // Get cards by user ID
    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
        return creditCardService.getCardsByUser(userId);
    }

    // Get all cards
    @GetMapping
    public List<CreditCardRecord> getAllCards() {
        return creditCardService.getAllCards();
    }
}
