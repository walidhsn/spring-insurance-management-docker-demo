package com.tn.esprit.assuranceexam.service;

import com.tn.esprit.assuranceexam.entity.Beneficiaire;
import com.tn.esprit.assuranceexam.enums.TypeContrat;

import java.util.Set;

public interface BeneficiaireService {
    public Beneficiaire ajouterBeneficiaire (Beneficiaire bf);
    public Set<Beneficiaire> getBeneficairesByType (TypeContrat typeContrat);
    public float getMontantBf (int cinBf);

}
