package com.example.tpcontrolekevinmasmejean.service;

import com.example.tpcontrolekevinmasmejean.modele.Masque;
import com.example.tpcontrolekevinmasmejean.repository.MasqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarnavalService implements ICarnavalService {
    MasqueRepository masqueRepository;

    @Autowired
    public CarnavalService(MasqueRepository masqueRepository) {
        this.masqueRepository = masqueRepository;
    }

    @Override
    public Iterable<Masque> getAll() {
        return masqueRepository.findAll();
    }

    @Override
    public Iterable<Masque> findByTheme(String theme) {
        return masqueRepository.findByThemeContains(theme);
    }

    @Override
    public Iterable<Masque> findWinnerForEachTheme() {
        return masqueRepository.findWinnerForEachTheme();
    }

    @Override
    public void add(Masque m) {
        masqueRepository.save(m);
    }

    @Override
    public Optional<Masque> getById(long id) {
        return masqueRepository.findById(id);
    }
}
