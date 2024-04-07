package com.tn.esprit.assuranceexam.dao;

import com.tn.esprit.assuranceexam.entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssuranceDao extends JpaRepository<Assurance, Integer> {
    @Query("SELECT a.beneficiaire.cin,COUNT(a) FROM Assurance a GROUP BY a.beneficiaire.cin")
    List<Object[]> countAssuranceByBeneficiaire();
}
