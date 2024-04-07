package com.tn.esprit.assuranceexam.controller;

import com.tn.esprit.assuranceexam.entity.Contrat;
import com.tn.esprit.assuranceexam.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ContratController {
    private final ContratService contratService;
    @Autowired
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }
    @PostMapping("/contrat")
    public ResponseEntity<Contrat> addcontrat(@RequestBody Contrat contrat){
        Date date = new Date();
        contrat.setDateEffet(date);
        Contrat result = contratService.ajouterContrat(contrat);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
    @GetMapping("/contrat/{id}")
    public ResponseEntity<Contrat> getOldestContrat(@PathVariable("id") Integer idBf){
        Contrat result = contratService.getContratBf(idBf);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
}
