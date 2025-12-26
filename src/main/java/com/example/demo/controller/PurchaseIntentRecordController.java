package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;

@RestController
@RequestMapping("/purchase-intents")
public class PurchaseIntentRecordController {

    private final PurchaseIntentService service;

    public PurchaseIntentRecordController(PurchaseIntentService service) {
        this.service = service;
    }

  
    @PostMapping
    public PurchaseIntentRecord createIntent(
            @RequestBody PurchaseIntentRecord intent) {
        return service.createIntent(intent);
    }

 
    @GetMapping("/user/{userId}")
    public List<PurchaseIntentRecord> getIntentsByUser(
            @PathVariable Long userId) {
        return service.getIntentsByUser(userId);
    }

   
    @GetMapping("/{id}")
    public PurchaseIntentRecord getIntentById(
            @PathVariable Long id) {
        return service.getIntentById(id);
    }

    @GetMapping
    public List<PurchaseIntentRecord> getAllIntents() {
        return service.getAllIntents();
    }
}


// package com.example.demo.controller;

// import com.example.demo.service.PurchaseIntentService;

// public class PurchaseIntentRecordController {

//     private final PurchaseIntentService service;

//     public PurchaseIntentRecordController(PurchaseIntentService service) {
//         this.service = service;
//     }
// }
