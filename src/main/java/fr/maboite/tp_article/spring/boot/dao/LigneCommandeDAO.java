package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Article;
import fr.maboite.tp_article.spring.boot.model.LigneCommande;
import fr.maboite.tp_article.spring.boot.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LigneCommandeDAO extends JpaRepository<LigneCommande, Long> {

    @Query("SELECT lc FROM LigneCommande lc WHERE lc.panier = :panier AND lc.article = :article")
    Optional<LigneCommande> findByPanierAndArticle(@Param("panier") Panier panier, @Param("article") Article article);
}
