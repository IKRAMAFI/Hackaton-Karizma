package com.example.demo.recipes.entity;


import jakarta.persistence.*;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la recette ne peut pas être vide")
    private String nom;

    @NotNull(message = "La liste d'ingrédients ne peut pas être nulle")
    private List<String> ingredients;

    @NotBlank(message = "Les étapes de préparation ne peuvent pas être vides")
    private String etapesPreparation;

    @NotNull(message = "La durée de préparation ne peut pas être nulle")
    private Integer dureePreparation;

    private String photo; // Chemin ou URL de la photo optionnelle

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getEtapesPreparation() {
        return etapesPreparation;
    }

    public void setEtapesPreparation(String etapesPreparation) {
        this.etapesPreparation = etapesPreparation;
    }

    public Integer getDureePreparation() {
        return dureePreparation;
    }

    public void setDureePreparation(Integer dureePreparation) {
        this.dureePreparation = dureePreparation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}