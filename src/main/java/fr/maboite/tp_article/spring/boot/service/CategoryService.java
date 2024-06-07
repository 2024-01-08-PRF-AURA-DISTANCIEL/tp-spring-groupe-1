package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    private Integer nextId = 1;

    public void save(Categorie categorie) {
        if (categorie == null) {
            throw new IllegalArgumentException("La catégorie ne peut être null");
        }
        LOGGER.info("Sauvegarde de la catégorie, avec le nom : " + categorie.getNom());

        if (categorie.getId() == null) {
            categorie.setId(Long.valueOf(nextId++));
        }
    }

    public void delete(Integer id) {
        LOGGER.info("Suppression de la catégorie avec l'id : " + id);
        // TODO Logique de supression
    }

    public Categorie findById(Integer id) {
        LOGGER.info("Récupération de la catégorie avec l'id : " + id);
        // Logique de récupération d'une catégorie par son ID
        // Ici, nous retournons une nouvelle instance pour l'exemple
        Categorie categorie = new Categorie();
        categorie.setId(Long.valueOf(id));
        categorie.setNom("Nom de catégorie");
        return categorie;
    }
}
