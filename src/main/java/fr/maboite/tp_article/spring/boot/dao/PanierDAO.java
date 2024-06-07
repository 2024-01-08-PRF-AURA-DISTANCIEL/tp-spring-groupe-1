package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Panier;
import fr.maboite.tp_article.spring.boot.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PanierDAO extends JpaRepository<Panier, Long> {

    @Query("SELECT p FROM Panier p WHERE p.utilisateur = :utilisateur AND p.statut = :statut")
    Optional<Panier> findByUtilisateurAndStatut(@Param("utilisateur") Utilisateur utilisateur, @Param("statut") String statut);
}
