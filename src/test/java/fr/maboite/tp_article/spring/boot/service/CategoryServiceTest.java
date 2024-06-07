package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.model.Categorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveNewCategorie() {
        Categorie categorie = new Categorie();
        categorie.setNom("Nouvelle Catégorie");

        categoryService.save(categorie);

        assertNotNull(categorie.getId());
        assertEquals(1, categorie.getId());
    }

    @Test
    void testSaveExistingCategorie() {
        Categorie categorie = new Categorie();
        categorie.setId(2L);
        categorie.setNom("Catégorie Existante");

        categoryService.save(categorie);

        assertEquals(2, categorie.getId());
    }

    @Test
    void testSaveNullCategorie() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            categoryService.save(null);
        });
        assertEquals("La catégorie ne peut être null", exception.getMessage());
    }

    @Test
    void testDeleteCategorie() {
        categoryService.delete(1);
        LOGGER.info("Suppression de la catégorie avec l'id : 1");
    }

    @Test
    void testFindById() {
        Categorie categorie = categoryService.findById(1);

        assertNotNull(categorie);
        assertEquals(1, categorie.getId());
        assertEquals("Nom de catégorie", categorie.getNom());
    }
}
