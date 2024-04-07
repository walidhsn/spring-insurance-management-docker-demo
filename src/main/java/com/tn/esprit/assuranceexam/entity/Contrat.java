package com.tn.esprit.assuranceexam.entity;

import com.tn.esprit.assuranceexam.enums.TypeContrat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contratId;
    private String matricule;
    private Date dateEffet;
    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;
}
