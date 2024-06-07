package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.dao.ArticleDAO;
import fr.maboite.tp_article.spring.boot.model.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDAO articleDao;

    @Test
    public void testCreateArticle() {
        // ARRANGE
        Article article = new Article();
        article.setNom("Mon Article");

        // ACT
        Article savedArticle = articleService.createArticle(article);

        // ASSERT
        Assertions.assertNotNull(savedArticle);
        Assertions.assertNotNull(savedArticle.getId());
        Assertions.assertEquals("Mon Article", savedArticle.getNom());
    }

    @Test
    public void testAddCategorieToArticle() {
        // ARRANGE
        Article article = new Article();
        article.setNom("Mon article avec type");
        Article savedArticle = articleDao.save(article);

        String typeArticle = "Type Example";

        // ACT
        Article articleWithCategorie = articleService.addCategorieToArticle(savedArticle, typeArticle);

        // ASSERT
        Assertions.assertNotNull(articleWithCategorie.getCategorie());
        Assertions.assertEquals(typeArticle, articleWithCategorie.getCategorie().getNom());
    }
}
