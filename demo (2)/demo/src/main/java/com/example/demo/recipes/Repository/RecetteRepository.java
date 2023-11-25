package com.example.demo.recipes.Repository;


import com.example.demo.recipes.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetteRepository extends JpaRepository<Recette, Long> {

    List<Recette> findByNomContainingIgnoreCase(String nom);

    // Ajoutez d'autres méthodes de requête personnalisées si nécessaire
}