package com.tn.esprit.assuranceexam.dao;

import com.tn.esprit.assuranceexam.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContratDao extends JpaRepository<Contrat,Integer> {
    Optional<Contrat> findByMatricule(String matricule);
    @Query("SELECT a.contrat FROM Assurance a WHERE a.beneficiaire.beneficiaireId = :idBf ORDER BY a.contrat.dateEffet ASC")
    Optional<Contrat> findOldestContratByBeneficiaireId(@Param("idBf") int idBf);
}
