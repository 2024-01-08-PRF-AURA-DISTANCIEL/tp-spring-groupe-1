package fr.maboite.tp_article.spring.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.tp_article.spring.boot.model.Utilisateur;
import fr.maboite.tp_article.spring.boot.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    /**
     * Create utilisateur response entity.
     *
     * @param utilisateur the utilisateur
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur nouveauUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.ok(nouveauUtilisateur);
    }

    /**
     * Update utilisateur response entity.
     *
     * @param id          the id
     * @param utilisateur the utilisateur
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurModifie = utilisateurService.updateUtilisateur(id, utilisateur);
        if (utilisateurModifie != null) {
            return ResponseEntity.ok(utilisateurModifie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> findById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(id);
        if (utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete utilisateur response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        boolean estSupprime = utilisateurService.deleteUtilisateur(id);
        if (estSupprime) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
