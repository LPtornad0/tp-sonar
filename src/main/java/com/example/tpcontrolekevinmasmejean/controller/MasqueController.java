package com.example.tpcontrolekevinmasmejean.controller;

import com.example.tpcontrolekevinmasmejean.modele.Masque;
import com.example.tpcontrolekevinmasmejean.service.ICarnavalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MasqueController {
    ICarnavalService carnavalService;

    @Autowired
    public MasqueController(ICarnavalService carnavalService) {
        this.carnavalService = carnavalService;
    }

    @GetMapping("/masque")
    public String listeMasque(Model model) {
        model.addAttribute("masques", carnavalService.getAll());
        return "listeMasque";
    }

    @GetMapping("/addMasque")
    public String ajouterMasque(Model model) {
        model.addAttribute("element", new Masque());
        return "ajouterMasque";
    }

    @PostMapping("/addMasque")
    public String ajouterMasquePost(@ModelAttribute Masque m) {
        carnavalService.add(m);
        return "redirect:/masque";
    }

    @GetMapping("/masque/recherche")
    public String searchByTheme(Model model, @RequestParam String theme) {
        model.addAttribute("masques", carnavalService.findByTheme(theme));
        return "listeMasque";
    }

    @GetMapping("/masque/{id}")
    public String detailMasque(Model model, @PathVariable long id) {
        Optional<Masque> m = carnavalService.getById(id);

        if(m.isEmpty()) {
            model.addAttribute("erreur", "Le masque n'existe pas");
            return "error";
        }

        model.addAttribute("m", m.get());
        return "detailMasque";
    }

    @GetMapping("/masque/resultats")
    public String winnerForEachTheme(Model model) {
        System.out.println("test");
        model.addAttribute("masques", carnavalService.findWinnerForEachTheme());
        return "listeMasque";
    }
}
