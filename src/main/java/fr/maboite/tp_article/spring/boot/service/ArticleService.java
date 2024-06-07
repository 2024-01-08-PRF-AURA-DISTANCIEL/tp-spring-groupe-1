package fr.maboite.tp_article.spring.boot.service;


import fr.maboite.tp_article.spring.boot.dao.ArticleDAO;
import fr.maboite.tp_article.spring.boot.model.Article;
import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDao;

    public Article createArticle(Article article) {
        return articleDao.save(article);
    }

    public Article addCategorieToArticle(Article article, String typeArticle) {
        Categorie categorie = new Categorie();
        categorie.setNom(typeArticle);
        article.setCategorie(categorie);
        return articleDao.save(article);
    }
}
