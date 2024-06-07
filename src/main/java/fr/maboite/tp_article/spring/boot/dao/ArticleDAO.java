package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleDAO extends CrudRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE LOWER(a.nom) LIKE %:keyword%")
    List<Article> findArticleByName(@Param("keyword") String keyword);
}
