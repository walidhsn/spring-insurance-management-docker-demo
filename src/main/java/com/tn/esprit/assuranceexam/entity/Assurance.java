package com.tn.esprit.assuranceexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assuranceId;
    private String designation;
    private Float montant;
    @ManyToOne
    @JsonIgnore
    private  Beneficiaire beneficiaire;
    @ManyToOne
    @JsonIgnore
    private Contrat contrat;
}
