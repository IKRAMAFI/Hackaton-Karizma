package com.example.demo.recipes.service;


import com.example.demo.recipes.Repository.RecetteRepository;
import com.example.demo.recipes.entity.Recette;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    public Optional<Recette> getRecetteById(Long id) {
        return recetteRepository.findById(id);
    }

    public List<Recette> searchRecettes(String keyword) {
        return recetteRepository.findByNomContainingIgnoreCase(keyword);
    }

    @Transactional
    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Transactional
    public Optional<Recette> updateRecette(Long id, Recette updatedRecette) {
        return getRecetteById(id).map(recette -> {
            recette.setNom(updatedRecette.getNom());
            recette.setIngredients(updatedRecette.getIngredients());
            recette.setEtapesPreparation(updatedRecette.getEtapesPreparation());
            recette.setDureePreparation(updatedRecette.getDureePreparation());
            recette.setPhoto(updatedRecette.getPhoto());
            return recetteRepository.save(recette);
        });
    }

    @Transactional
    public boolean deleteRecette(Long id) {
        if (recetteRepository.existsById(id)) {
            recetteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}