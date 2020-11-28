package com.backend.api.dao;

import com.backend.api.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {

    @Query("SELECT c FROM Commande c WHERE c.username = ?1")
    List<Commande> findCommandeByUsername(String username);
}
