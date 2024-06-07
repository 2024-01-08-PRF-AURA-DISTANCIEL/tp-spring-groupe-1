package fr.maboite.tp_article.spring.boot.service;

import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.tp_article.spring.boot.dao.UtilisateurDAO;
import fr.maboite.tp_article.spring.boot.model.Utilisateur;

/**
 * The type Utilisateur service.
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;

    /**
     * Create utilisateur utilisateur.
     *
     * @param utilisateur the utilisateur
     * @return the utilisateur
     */
    @Transactional
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurDAO.save(utilisateur);
    }

    /**
     * Update utilisateur utilisateur.
     *
     * @param id          the id
     * @param utilisateur the utilisateur
     * @return the utilisateur
     */
    @Transactional
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurDAO.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setNom(utilisateur.getNom());
            existingUtilisateur.setPrenom(utilisateur.getPrenom());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setPointsFidelite(utilisateur.getPointsFidelite());
            return utilisateurDAO.save(existingUtilisateur);
        } else {
            return null;
        }
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Utilisateur> findById(Long id) {
        return utilisateurDAO.findById(id);
    }

    /**
     * Delete utilisateur boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @Transactional
    public boolean deleteUtilisateur(Long id) {
        if (!utilisateurDAO.existsById(id)) {
            return false;
        }
        utilisateurDAO.deleteById(id);
        return true;
    }
}
