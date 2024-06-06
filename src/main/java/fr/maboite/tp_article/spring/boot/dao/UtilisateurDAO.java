package fr.maboite.tp_article.spring.boot.dao;

import fr.maboite.tp_article.spring.boot.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public abstract class UtilisateurDAO extends CrudRepository<Utilisateur, Long> {
}
