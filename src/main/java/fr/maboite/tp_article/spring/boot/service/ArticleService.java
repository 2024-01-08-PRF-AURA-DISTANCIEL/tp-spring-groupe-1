package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.model.Article;
import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TypeArticleDao typeArticleDao;

    @Test
    public void testArticle() {
        //ARRANGE
        Article article = new Article();
        article.setNom("Mon Article");

        //ACT
        Article saveArticle = articleDao.save(article);
        //ASSERT
        Assertions.assertNotNull(saveArticle);
        Assertions.assertNotNull(saveArticle.getId());
        Assertions.assertEquals("Mon Article", saveArticle.getName());
    }

    @Test
    public void addTypeArticle(String typeArticle){
        Article article = new Article();
        article.setNom("Mon article avec type");

        Categorie categorie = new Categorie();
        categorie.setNom(typeArticle);
        Categorie saveCategorie = typeArticleDao.save(categorie);

        article.setCategorie(saveCategorie);

        Article saveArticle = articleDao.save(article);

        Assertions.assertNotNull(saveArticle.getCategorie());
    }
}
