package com.tn.esprit.assuranceexam.dao;

import com.tn.esprit.assuranceexam.entity.Beneficiaire;
import com.tn.esprit.assuranceexam.enums.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface BeneficiaireDao extends JpaRepository<Beneficiaire,Integer> {
    Optional<Beneficiaire> findByCin(Integer cin);
    @Query("SELECT DISTINCT a.beneficiaire FROM Assurance a WHERE a.contrat.typeContrat =:typeContrat")
    Set<Beneficiaire> findBeneficiairesByTypeContrat(@Param("typeContrat") TypeContrat typeContrat);
}
