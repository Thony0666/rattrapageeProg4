package com.anthonyo.kfc.patrimoineapi.modele;

import java.time.LocalDateTime;

public class Patrimoine {
    private String possesseur;
    private LocalDateTime derniereModification;

    // Getters et Setters
    public String getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(String possesseur) {
        this.possesseur = possesseur;
        this.derniereModification = LocalDateTime.now(); // Mettre à jour la date à chaque modification
    }

    public LocalDateTime getDerniereModification() {
        return derniereModification;
    }
}
