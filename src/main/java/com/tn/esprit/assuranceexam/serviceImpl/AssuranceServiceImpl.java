package com.tn.esprit.assuranceexam.serviceImpl;

import com.tn.esprit.assuranceexam.dao.AssuranceDao;
import com.tn.esprit.assuranceexam.dao.BeneficiaireDao;
import com.tn.esprit.assuranceexam.dao.ContratDao;
import com.tn.esprit.assuranceexam.entity.Assurance;
import com.tn.esprit.assuranceexam.entity.Beneficiaire;
import com.tn.esprit.assuranceexam.entity.Contrat;
import com.tn.esprit.assuranceexam.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssuranceServiceImpl implements AssuranceService {
    private final AssuranceDao assuranceDao;
    private final BeneficiaireDao beneficiaireDao;
    private final ContratDao contratDao;
    @Autowired
    public AssuranceServiceImpl(AssuranceDao assuranceDao,BeneficiaireDao beneficiaireDao,ContratDao contratDao) {
        this.assuranceDao = assuranceDao;
        this.beneficiaireDao = beneficiaireDao;
        this.contratDao = contratDao;
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, Integer cinBf, String matricule) {
        Optional<Contrat> optionalContrat = contratDao.findByMatricule(matricule);
        Optional<Beneficiaire> optionalBeneficiaire = beneficiaireDao.findByCin(cinBf) ;
        if(optionalBeneficiaire.isPresent() && optionalContrat.isPresent()){
            a.setContrat(optionalContrat.get());
            a.setBeneficiaire(optionalBeneficiaire.get());
            return assuranceDao.save(a);
        }
        return null;
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void statistiques() {
        List<Object[]> result = assuranceDao.countAssuranceByBeneficiaire();
        if(!result.isEmpty()){
            Map<Integer,Integer> myStat = new TreeMap<>(Collections.reverseOrder());
            for (Object[] row : result){
                int cin = (int) row[0];
                long count = (long) row[1];
                myStat.put((int)count,cin);
            }
            System.out.println("> Statistiques des assurances par bénéficiaire (ordonnées par nombre d'assurances) : ");
            for (Map.Entry<Integer, Integer> entry : myStat.entrySet()) {
                System.out.println("CIN: " + entry.getValue() + ", Nombre d'assurances: " + entry.getKey());
            }
        }else{
            System.out.println("Aucune assurance n'a été trouvée.");
        }

    }


}
