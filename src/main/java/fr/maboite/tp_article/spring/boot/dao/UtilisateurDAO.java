package fr.maboite.tp_article.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import fr.maboite.tp_article.spring.boot.model.Utilisateur;

public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long> {
}
