package com.tn.esprit.assuranceexam.serviceImpl;

import com.tn.esprit.assuranceexam.dao.BeneficiaireDao;
import com.tn.esprit.assuranceexam.dao.ContratDao;
import com.tn.esprit.assuranceexam.entity.Contrat;
import com.tn.esprit.assuranceexam.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContratServiceImpl implements ContratService {
    private final ContratDao contratDao;
    private final BeneficiaireDao beneficiaireDao;
    @Autowired
    public ContratServiceImpl(ContratDao contratDao,BeneficiaireDao beneficiaireDao) {
        this.contratDao = contratDao;
        this.beneficiaireDao = beneficiaireDao;
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratDao.save(c);
    }

    @Override
    public Contrat getContratBf(Integer idBf) {
        Optional<Contrat> optionalContrat = contratDao.findOldestContratByBeneficiaireId(idBf);
        return optionalContrat.orElse(null);
    }
}
