package fr.maboite.tp_article.spring.boot.model;

import jakarta.persistence.*;

@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nombreArticles;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Panier panier;

    // ! Getter et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNombreArticles() {
        return nombreArticles;
    }

    public void setNombreArticles(Integer nombreArticles) {
        this.nombreArticles = nombreArticles;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
