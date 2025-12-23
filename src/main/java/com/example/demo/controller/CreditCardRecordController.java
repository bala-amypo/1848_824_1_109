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

    private final CreditCardService ccs;

    public CreditCardRecordController(CreditCardService ccs) {
        this.ccs = ccs;
    }
    @PostMapping("/add")
    public CreditCardRecord addCard(@RequestBody CreditCardRecord card) {
        return ccs.addCard(card);
    }


    @PostMapping("/ping")
public String ping() {
    return "PING OK";
}
}
