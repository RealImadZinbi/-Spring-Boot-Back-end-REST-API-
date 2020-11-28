package com.backend.api.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name="image")
    private String image;

    @Column(name="nom_produit")
    private String nom;

    @Column(name="quantite")
    private BigDecimal quantite;

    @Column(name="prixUnitaire")
    private BigDecimal prixUnitaire;

    @Column(name="sousTotal")
    private BigDecimal sousTotal;

    @Column(name="username")
    private String username;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNomProduit() {
        return nom;
    }

    public void setNomProduit(String nomProduit) {
        this.nom = nomProduit;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(BigDecimal sousTotal) {
        this.sousTotal = sousTotal;
    }


}
