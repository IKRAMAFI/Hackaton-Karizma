package com.example.demo.recipes.controller;


//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.recipes.entity.Recette;
import com.example.demo.recipes.service.RecetteService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//
@Controller
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping
    public String getAllRecettes(Model model) {
        List<Recette> recettes = recetteService.getAllRecettes();
        model.addAttribute("recettes", recettes);
        return "recettes";
    }

    @GetMapping("/{id}")
    public String getRecetteById(@PathVariable Long id, Model model) {
        Recette recette = recetteService.getRecetteById(id)
                .orElse(null);

        if (recette != null) {
            model.addAttribute("recette", recette);
            return "recette-details";
        } else {
            return "error";
        }
    }

    @GetMapping("/search")
    public String searchRecettes(@RequestParam String keyword, Model model) {
        List<Recette> recettes = recetteService.searchRecettes(keyword);
        model.addAttribute("recettes", recettes);
        return "recettes";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/recettes")
    public String createRecette(@RequestBody Recette recette) {
        recetteService.createRecette(recette);
        return "redirect:/recettes";
    }

    @PutMapping("/recettes/{id}")
    public String updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
        recetteService.updateRecette(id, updatedRecette);
        return "redirect:/recettes";
    }

    @PostMapping("/recettes/{id}/delete")
    public String deleteRecette(@PathVariable Long id) {
        recetteService.deleteRecette(id);
        return "redirect:/recettes";
    }
}
//@RequestMapping("/recettes")
//public class RecetteController {
//
//    @Autowired
//    private RecetteService recetteService;
//
//    @GetMapping
//    public String getAllRecettes(Model model) {
//        List<Recette> recettes = recetteService.getAllRecettes();
//        model.addAttribute("recettes", recettes);
//        return "recettes";
//    }
//
//    @GetMapping("/{id}")
//    public String getRecetteById(@PathVariable Long id) {
//        return recetteService.getRecetteById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("recettes/search")
//    public List<Recette> searchRecettes(@RequestParam String keyword) {
//        return recetteService.searchRecettes(keyword);
//    }
//
//    @PostMapping("/recettes")
//    public ResponseEntity<Recette> createRecette(@RequestBody Recette recette) {
//        Recette createdRecette = recetteService.createRecette(recette);
//        return ResponseEntity.created(URI.create("/api/recettes/" + createdRecette.getId())).body(createdRecette);
//    }
//
//    @PutMapping("recettes/{id}")
//    public ResponseEntity<Recette> updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
//        return recetteService.updateRecette(id, updatedRecette)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("recettes/{id}")
//    public ResponseEntity<Void> deleteRecette(@PathVariable Long id) {
//        if (recetteService.deleteRecette(id)) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}