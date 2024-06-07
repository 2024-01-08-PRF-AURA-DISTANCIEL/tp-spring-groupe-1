-- MySQL Workbench Forward Engineering

CREATE SCHEMA IF NOT EXISTS `ventes_articles` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `ventes_articles`;

-- Table pour les catégories d'articles
CREATE TABLE IF NOT EXISTS `categorie`
(
    `id`  INT          NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- Table pour les articles
CREATE TABLE IF NOT EXISTS `article`
(
    `id`                INT            NOT NULL AUTO_INCREMENT,
    `nom`               VARCHAR(150)   NOT NULL,
    `prix`              DECIMAL(10, 2) NULL DEFAULT NULL,
    `quantite_en_stock` INT            NULL DEFAULT NULL,
    `points_fidelite`   INT            NULL DEFAULT NULL,
    `categorie_id`      INT            NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- Table pour les utilisateurs
CREATE TABLE IF NOT EXISTS `utilisateur`
(
    `id`              INT          NOT NULL AUTO_INCREMENT,
    `nom`             VARCHAR(100) NOT NULL,
    `prenom`          VARCHAR(100) NOT NULL,
    `email`           VARCHAR(250) NOT NULL,
    `points_fidelite` INT          NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- Table pour les paniers
CREATE TABLE IF NOT EXISTS `panier`
(
    `id`             INT          NOT NULL AUTO_INCREMENT,
    `date_creation`  DATE         NOT NULL,
    `statut`         VARCHAR(100) NOT NULL,
    `utilisateur_id` INT          NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

-- Table pour les lignes de commande
CREATE TABLE IF NOT EXISTS `ligne_commande`
(
    `id`           INT NOT NULL AUTO_INCREMENT,
    `articles_qty` INT NULL DEFAULT NULL,
    `panier_id`    INT NULL,
    `article_id`   INT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`panier_id`) REFERENCES `panier` (`id`),
    FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;

-- Insérer des données fictives dans la table categorie
INSERT INTO `categorie` (`nom`)
VALUES ('Électronique'),
       ('Vêtements'),
       ('Maison'),
       ('Jouets'),
       ('Livres');

-- Insérer des données fictives dans la table article
INSERT INTO `article` (`nom`, `prix`, `quantite_en_stock`, `points_fidelite`, `categorie_id`)
VALUES ('Télévision', 299.99, 50, 30, 1),
       ('Jeans', 49.99, 100, 10, 2),
       ('Table', 89.99, 20, 15, 3),
       ('Poupée', 19.99, 200, 5, 4),
       ('Roman', 14.99, 150, 7, 5);

-- Insérer des données fictives dans la table utilisateur
INSERT INTO `utilisateur` (`nom`, `prenom`, `email`, `points_fidelite`)
VALUES ('Dupont', 'Jean', 'jean.dupont@example.com', 100),
       ('Martin', 'Marie', 'marie.martin@example.com', 200),
       ('Bernard', 'Pierre', 'pierre.bernard@example.com', 300),
       ('Dubois', 'Sophie', 'sophie.dubois@example.com', 400),
       ('Petit', 'Luc', 'luc.petit@example.com', 500);

-- Insérer des données fictives dans la table panier
INSERT INTO `panier` (`date_creation`, `statut`, `utilisateur_id`)
VALUES ('2024-01-01', 'PANIER', 1),
       ('2024-01-02', 'PANIER', 2),
       ('2024-01-03', 'PANIER', 3),
       ('2024-01-04', 'PANIER', 4),
       ('2024-01-05', 'PANIER', 5);

-- Insérer des données fictives dans la table ligne_commande
INSERT INTO `ligne_commande` (`articles_qty`, `panier_id`, `article_id`)
VALUES (2, 1, 1),
       (1, 2, 2),
       (3, 3, 3),
       (5, 4, 4),
       (4, 5, 5);
