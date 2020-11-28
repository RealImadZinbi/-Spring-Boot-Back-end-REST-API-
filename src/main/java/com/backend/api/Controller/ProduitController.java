package com.backend.api.Controller;

import com.backend.api.dao.ProduitRepository;
import com.backend.api.entity.Produit;
import com.backend.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
    public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/produits")
    public List<Produit>  getAllProducts() {
        return produitRepository.findAll();
    }
    @GetMapping("/produits/{id}")
    public ResponseEntity<Produit> getProductById(@PathVariable(value = "id") Long productId)
        throws ResourceNotFoundException {
        Produit product = produitRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

     @PostMapping("/produits")
    public Produit addProduct(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/produits/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") Long productId,
                                                 @RequestBody Produit productDetails) throws ResourceNotFoundException {
        Produit produit = produitRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Prodct not found for this id :: " + productId));

        produit.setNomProduit(productDetails.getNomProduit());
        produit.setQuantite(productDetails.getQuantite());
        produit.setDescription(productDetails.getDescription());
        produit.setCategorie(productDetails.getCategorie());
        produit.setImage(productDetails.getImage());
        produit.setPrixUnitaire(productDetails.getPrixUnitaire());
        final Produit updatedProduit = produitRepository.save(produit);
        return ResponseEntity.ok(updatedProduit);


    }
    @DeleteMapping("produits/{id}")
    public Map<String,Boolean> deleteProduct(@PathVariable(value="id") Long productId)
        throws  ResourceNotFoundException {
        Produit produit = produitRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id ::" + productId));

        produitRepository.delete(produit);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
