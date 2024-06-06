package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleDaoTest articleDaoTest;

    @Test
    public void testCreateReadDeleteArticle() {

        Article article = new Article();
        article.setNom("Nom de l'article");
        article.setPrix(10.0);
        article.setQuantiteEnStock(100);
        article.setPointsFidelite(10);

        Article savedARticle.save
    }

}
