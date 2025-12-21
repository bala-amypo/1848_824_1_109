package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/cards")
public class CreditCardRecordController {
    
    @Autowired
    CreditCardService ccs;
    
    @PostMapping
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return ccs.addCard(card);
    }
    //@PutMapping("/{id}")
    //public CreditCardRecord updateCard(
           //@PathVariable Long id,
           // @RequestBody CreditCardRecord updated) {

       // return ccs.updateCard(id, updated);
    //}
   // @GetMapping("/{id}")
    //public CreditCardRecord getCardById(@PathVariable Long id) {
       // return ccs.getCardById(id);
    //}
    //@GetMapping("/user/{userId}")
    //public List<CreditCardRecord> getCardsByUser(@PathVariable Long userId) {
       // return ccs.getCardsByUser(userId);
    //}
   // @GetMapping
   // public List<CreditCardRecord> getAllCards() {
      //  return ccs.getAllCards();
   // }
}
