package com.tn.esprit.assuranceexam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer beneficiaireId;
    private Integer cin;
    private String nom;
    private String prenom;
    private String profession;
    private Float salaire;
    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Assurance> assurances= new ArrayList<>();
}
