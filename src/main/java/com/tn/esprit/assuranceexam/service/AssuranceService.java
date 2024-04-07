package com.tn.esprit.assuranceexam.service;

import com.tn.esprit.assuranceexam.entity.Assurance;

public interface AssuranceService {
    public Assurance ajouterAssurance (Assurance a, Integer cinBf, String matricule);
    public void statistiques ();
}
