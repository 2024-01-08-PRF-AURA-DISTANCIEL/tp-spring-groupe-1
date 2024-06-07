package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.dao.ArticleDAO;
import fr.maboite.tp_article.spring.boot.dao.PanierDAO;
import fr.maboite.tp_article.spring.boot.dao.UtilisateurDAO;
import fr.maboite.tp_article.spring.boot.dao.LigneCommandeDAO;
import fr.maboite.tp_article.spring.boot.model.Article;
import fr.maboite.tp_article.spring.boot.model.Panier;
import fr.maboite.tp_article.spring.boot.model.Utilisateur;
import fr.maboite.tp_article.spring.boot.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticlePanierService {

    @Autowired
    private UtilisateurDAO utilisateurDAO;

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private PanierDAO panierDAO;

    @Autowired
    private LigneCommandeDAO ligneCommandeDAO;

    public void ajouterAuPanier(Long utilisateurId, Long articleId, Integer nombreArticles) {
        Optional<Utilisateur> utilisateurOpt = utilisateurDAO.findById(utilisateurId);
        if (!utilisateurOpt.isPresent()) {
            throw new IllegalArgumentException("Utilisateur non trouvé.");
        }

        Optional<Article> articleOpt = articleDAO.findById(articleId);
        if (!articleOpt.isPresent()) {
            throw new IllegalArgumentException("Article non trouvé.");
        }

        Utilisateur utilisateur = utilisateurOpt.get();
        Article article = articleOpt.get();

        Panier panier = panierDAO.findByUtilisateurAndStatut(utilisateur, "PANIER").orElseGet(() -> {
            Panier nouveauPanier = new Panier();
            nouveauPanier.setUtilisateur(utilisateur);
            nouveauPanier.setStatut("PANIER");
            return panierDAO.save(nouveauPanier);
        });

        Optional<LigneCommande> ligneCommandeOpt = ligneCommandeDAO.findByPanierAndArticle(panier, article);
        if (ligneCommandeOpt.isPresent()) {
            LigneCommande ligneCommande = ligneCommandeOpt.get();
            ligneCommande.setNombreArticles(ligneCommande.getNombreArticles() + nombreArticles);
            ligneCommandeDAO.save(ligneCommande);
        } else {
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setPanier(panier);
            ligneCommande.setArticle(article);
            ligneCommande.setNombreArticles(nombreArticles);
            ligneCommandeDAO.save(ligneCommande);
        }
    }
}
