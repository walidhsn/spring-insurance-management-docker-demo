package com.tn.esprit.assuranceexam.controller;

import com.tn.esprit.assuranceexam.entity.Assurance;
import com.tn.esprit.assuranceexam.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AssuranceController {
    private final AssuranceService assuranceService;
    @Autowired
    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }
    @PostMapping("/Assurance")
    public ResponseEntity<Assurance> addAssurance(@RequestBody Assurance assurance, @RequestParam Integer cinBf,@RequestParam String matricule){
        Assurance result = assuranceService.ajouterAssurance(assurance,cinBf,matricule);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
}
