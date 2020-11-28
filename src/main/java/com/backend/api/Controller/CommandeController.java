package com.backend.api.Controller;

import com.backend.api.dao.CommandeRepository;

import com.backend.api.entity.Commande;
import com.backend.api.entity.Produit;
import com.backend.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")

public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("/Commandes")
    public List<Commande> getAllCommandes() {
        return  commandeRepository.findAll();
    }

    @GetMapping("/Commandes/{id}")
        public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") Long commandeId)
        throws ResourceNotFoundException {
        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found for this Id : : " + commandeId));
        return ResponseEntity.ok().body(commande);
    }
    @GetMapping("/commande/{username}")
      public List<Commande> getCommandeByUsername(@PathVariable(value= "username") String username) {
        return commandeRepository.findCommandeByUsername(username);
    }
    @PostMapping("/Commandes")
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }

}
