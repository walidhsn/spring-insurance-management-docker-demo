package com.tn.esprit.assuranceexam.service;

import com.tn.esprit.assuranceexam.entity.Contrat;

public interface ContratService {
    public Contrat ajouterContrat (Contrat c);
    public Contrat getContratBf (Integer idBf);
}
