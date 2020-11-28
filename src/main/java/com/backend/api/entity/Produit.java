package com.backend.api.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Produit")
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name="nom_produit")
    private String nomProduit;

    @Column(name="description_produit")
    private String description;

    @Column(name="quantite_produit")
    private BigDecimal quantite;



    @Column(name="image_produit")
    private String image;

    @Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }



    public long getId() {
        return id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomProduit(String productName) {
        this.nomProduit = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public String getCategorie() {
        return categorie;
    }

    @Column(name="categorie")
    private String categorie;

    @Override
    public String toString() {
        return super.toString();
    }
}
