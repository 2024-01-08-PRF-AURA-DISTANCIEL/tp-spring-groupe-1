package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public abstract class ArticleDAO extends CrudRepository<Article, Long> {
}
