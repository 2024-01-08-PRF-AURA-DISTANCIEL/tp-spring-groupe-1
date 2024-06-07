package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleDAO articleDAO;

    @Test
    public void testCreateReadDeleteArticle() {
        // Create an article
        Article article = new Article();
        article.setNom("Nom de l'article");
        article.setPrix(10.0);
        article.setQuantiteEnStock(100);
        article.setPointsFidelite(10);

        // Save the article
        Article savedArticle = articleDAO.save(article);
        assertNotNull(savedArticle);
        assertNotNull(savedArticle.getId());

        // Read the article
        Article foundArticle = articleDAO.findById(savedArticle.getId()).orElse(null);
        assertNotNull(foundArticle);
        assertEquals("Nom de l'article", foundArticle.getNom());
        assertEquals(10.0, foundArticle.getPrix());
        assertEquals(100, foundArticle.getQuantiteEnStock());
        assertEquals(10, foundArticle.getPointsFidelite());

        // Delete the article
        articleDAO.deleteById(savedArticle.getId());

        // Verify the article is deleted
        Article deletedArticle = articleDAO.findById(savedArticle.getId()).orElse(null);
        assertNull(deletedArticle);
    }
}
