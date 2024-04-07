package com.tn.esprit.assuranceexam.serviceImpl;

import com.tn.esprit.assuranceexam.dao.BeneficiaireDao;
import com.tn.esprit.assuranceexam.entity.Assurance;
import com.tn.esprit.assuranceexam.entity.Beneficiaire;
import com.tn.esprit.assuranceexam.enums.TypeContrat;
import com.tn.esprit.assuranceexam.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {
    private final BeneficiaireDao beneficiaireDao;
    @Autowired
    public BeneficiaireServiceImpl(BeneficiaireDao beneficiaireDao) {
        this.beneficiaireDao = beneficiaireDao;
    }

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireDao.save(bf);
    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {
        return beneficiaireDao.findBeneficiairesByTypeContrat(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireDao.findByCin(cinBf);
        float montantAnnuel = 0;
        if(optionalBeneficiaire.isPresent()){
            Beneficiaire beneficiaire = optionalBeneficiaire.get();
            for(Assurance assurance : beneficiaire.getAssurances()){
                switch (assurance.getContrat().getTypeContrat()){
                    case SEMESTRIEL :
                        montantAnnuel+= (assurance.getMontant() * 2);
                        break;
                    case MENSUEL:
                        montantAnnuel+= (assurance.getMontant() * 12);
                        break;
                    default:
                        montantAnnuel+= assurance.getMontant();
                }
            }
        }
        return montantAnnuel;
    }
}
