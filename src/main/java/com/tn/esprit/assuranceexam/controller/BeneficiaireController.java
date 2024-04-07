package com.tn.esprit.assuranceexam.controller;

import com.tn.esprit.assuranceexam.entity.Beneficiaire;
import com.tn.esprit.assuranceexam.enums.TypeContrat;
import com.tn.esprit.assuranceexam.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class BeneficiaireController {
    private final BeneficiaireService beneficiaireService;
    @Autowired
    public BeneficiaireController(BeneficiaireService beneficiaireService) {
        this.beneficiaireService = beneficiaireService;
    }
    @PostMapping("/beneficiaire")
    public ResponseEntity<Beneficiaire> addBeneficiaire(@RequestBody Beneficiaire beneficiaire){
        Beneficiaire result = beneficiaireService.ajouterBeneficiaire(beneficiaire);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
    @GetMapping("/beneficiaire/contratType")
    public ResponseEntity<Set<Beneficiaire>> getBeneficiaires(@RequestParam TypeContrat typeContrat){
        return  ResponseEntity.ok(beneficiaireService.getBeneficairesByType(typeContrat));
    }
    @GetMapping("/beneficiaire/montant/{cin}")
    public ResponseEntity<Float> getBeneficiaire(@PathVariable("cin") Integer cin){
        Float result = beneficiaireService.getMontantBf(cin);
        return result!=0 ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }
}
