package com.example.tpcontrolekevinmasmejean.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Masque {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String nomCreateur;

    @NotBlank
    private String theme;

    @NotNull
    private Double prixFabrication;

    private int nbVotes;

    public Masque() {}

    public Masque(String nomCreateur, String theme, Double prixFabrication, int nbVotes) {
        this.nomCreateur = nomCreateur;
        this.theme = theme;
        this.prixFabrication = prixFabrication;
        this.nbVotes = nbVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCreateur() {
        return nomCreateur;
    }

    public void setNomCreateur(String nomCreateur) {
        this.nomCreateur = nomCreateur;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Double getPrixFabrication() {
        return prixFabrication;
    }

    public void setPrixFabrication(Double prixFabrication) {
        this.prixFabrication = prixFabrication;
    }

    public int getNbVotes() {
        return nbVotes;
    }

    public void setNbVotes(int nbVotes) {
        this.nbVotes = nbVotes;
    }
}
