package fr.maboite.tp_article.spring.boot.service;

import fr.maboite.tp_article.spring.boot.dao.UtilisateurDAO;
import fr.maboite.tp_article.spring.boot.model.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtilisateurServiceTest {

    @InjectMocks
    private UtilisateurService utilisateurService;

    @Mock
    private UtilisateurDAO utilisateurDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Dupont");
        utilisateur.setPrenom("Jean");
        utilisateur.setEmail("jean.dupont@example.com");

        when(utilisateurDAO.save(any(Utilisateur.class))).thenReturn(utilisateur);

        Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);

        assertNotNull(createdUtilisateur);
        assertEquals("Dupont", createdUtilisateur.getNom());
        assertEquals("Jean", createdUtilisateur.getPrenom());
        assertEquals("jean.dupont@example.com", createdUtilisateur.getEmail());
    }

    @Test
    void testUpdateUtilisateur() {
        Utilisateur existingUtilisateur = new Utilisateur();
        existingUtilisateur.setId(1L);
        existingUtilisateur.setNom("Dupont");
        existingUtilisateur.setPrenom("Jean");
        existingUtilisateur.setEmail("jean.dupont@example.com");

        Utilisateur updatedUtilisateur = new Utilisateur();
        updatedUtilisateur.setNom("Durand");
        updatedUtilisateur.setPrenom("Paul");
        updatedUtilisateur.setEmail("paul.durand@example.com");

        when(utilisateurDAO.findById(1L)).thenReturn(Optional.of(existingUtilisateur));
        when(utilisateurDAO.save(any(Utilisateur.class))).thenReturn(existingUtilisateur);

        Utilisateur result = utilisateurService.updateUtilisateur(1L, updatedUtilisateur);

        assertNotNull(result);
        assertEquals("Durand", result.getNom());
        assertEquals("Paul", result.getPrenom());
        assertEquals("paul.durand@example.com", result.getEmail());
    }

    @Test
    void testUpdateUtilisateurNotFound() {
        when(utilisateurDAO.findById(1L)).thenReturn(Optional.empty());

        Utilisateur updatedUtilisateur = new Utilisateur();
        updatedUtilisateur.setNom("Durand");
        updatedUtilisateur.setPrenom("Paul");
        updatedUtilisateur.setEmail("paul.durand@example.com");

        Utilisateur result = utilisateurService.updateUtilisateur(1L, updatedUtilisateur);

        assertNull(result);
    }

    @Test
    void testFindById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setNom("Dupont");
        utilisateur.setPrenom("Jean");
        utilisateur.setEmail("jean.dupont@example.com");

        when(utilisateurDAO.findById(1L)).thenReturn(Optional.of(utilisateur));

        Optional<Utilisateur> result = utilisateurService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Dupont", result.get().getNom());
        assertEquals("Jean", result.get().getPrenom());
        assertEquals("jean.dupont@example.com", result.get().getEmail());
    }

    @Test
    void testDeleteUtilisateur() {
        when(utilisateurDAO.existsById(1L)).thenReturn(true);

        boolean result = utilisateurService.deleteUtilisateur(1L);

        assertTrue(result);
        verify(utilisateurDAO, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteUtilisateurNotFound() {
        when(utilisateurDAO.existsById(1L)).thenReturn(false);

        boolean result = utilisateurService.deleteUtilisateur(1L);

        assertFalse(result);
        verify(utilisateurDAO, never()).deleteById(1L);
    }
}
