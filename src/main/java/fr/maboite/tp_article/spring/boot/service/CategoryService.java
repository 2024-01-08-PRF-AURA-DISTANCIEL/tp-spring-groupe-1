package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;


@Component
public class CategoryService {

    private Integer nextId = 1;

    public void save(Categorie categorie) {
        if(categorie == null) {
            throw new IllegalArgumentException("Bateau ne peut être null");
        }
        LOGGER.info("Sauvegarde de la catégorie, avec le nom : " + categorie.getNom());

        if(categorie.getId() == null) {
            categorie.setId(nextId++);
        }
    }

    public void delete(Integer id ) {
        LOGGER.info("Suppression de la catégorie avec l'id : " + id);
    }
}
