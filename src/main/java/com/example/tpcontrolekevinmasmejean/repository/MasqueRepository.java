package com.example.tpcontrolekevinmasmejean.repository;

import com.example.tpcontrolekevinmasmejean.modele.Masque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasqueRepository extends CrudRepository<Masque, Long> {
    Iterable<Masque> findByThemeContains(String theme);

    // Si il y a égalités sur un théme, affiche les x gagnants pour le themes en question
    @Query("SELECT m FROM Masque m WHERE m.nbVotes = (SELECT MAX(m2.nbVotes) FROM Masque m2 WHERE m2.theme = m.theme)")
    Iterable<Masque> findWinnerForEachTheme();
}
