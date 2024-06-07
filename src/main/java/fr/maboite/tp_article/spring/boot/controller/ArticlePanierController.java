package fr.maboite.tp_article.spring.boot.controller;

import fr.maboite.tp_article.spring.boot.service.ArticlePanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panier")
public class ArticlePanierController {

    @Autowired
    private ArticlePanierService articlePanierService;

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterAuPanier(@RequestParam Long utilisateurId, @RequestParam Long articleId, @RequestParam Integer nombreArticles) {
        try {
            articlePanierService.ajouterAuPanier(utilisateurId, articleId, nombreArticles);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
