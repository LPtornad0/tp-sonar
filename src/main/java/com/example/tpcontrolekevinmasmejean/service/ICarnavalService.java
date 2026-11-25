package com.example.tpcontrolekevinmasmejean.service;


import com.example.tpcontrolekevinmasmejean.modele.Masque;

import java.util.Optional;

public interface ICarnavalService {
    Iterable<Masque> getAll();
    Iterable<Masque> findByTheme(String theme);
    Iterable<Masque> findWinnerForEachTheme();
    void add(Masque m);
    Optional<Masque> getById(long id);
}
