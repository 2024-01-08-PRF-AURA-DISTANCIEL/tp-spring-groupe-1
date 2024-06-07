package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryDAO extends CrudRepository<Categorie, Long> {

    @Query("SELECT c FROM Categorie c WHERE LOWER(c.nom) LIKE %:keyword%")
    List<Categorie> findCategoryByName(@Param("keyword") String keyword);
}
