package com.j2ee.tdspring.controllers;

import com.j2ee.tdspring.entities.Sortie;
import com.j2ee.tdspring.services.SortieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class SortieController {
    @Autowired
    private SortieService sortieService;

    @RequestMapping(path = "/add-test-sortie", method = RequestMethod.GET)
    @Valid
    public void addTestSortie() {
        Date date = new Date();

        Sortie sortie = new Sortie();
        sortie.setDateSortie(date);
        sortie.setComplexite(4);
        sortie.setDescription("Description de test");
        sortie.setLieu("Lyon");
        sortie.setNom("Nom");
        sortie.setDuree(15);
        sortieService.createOrUpdate(sortie);
    }

    @RequestMapping(path = "/sortie", method = RequestMethod.GET)
    public Sortie getSortie(@RequestParam(value = "id") Integer identifiant) {
        return sortieService.getSortieById(identifiant);
    }

    @Operation(summary = "Création ou mise à jour d'un utilisateur")
    @RequestMapping(path = "/sortie", method = RequestMethod.PUT)
    @Valid
    public Sortie addOrUpdateSortie(@RequestBody Sortie sortie) {
        return sortieService.createOrUpdate(sortie);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/sorties/all", method = RequestMethod.GET)
    public List<Sortie> getSorties() {
        return sortieService.getAllSorties();
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/sortie", method = RequestMethod.DELETE)
    public void deleteSortie(@RequestParam(value = "id") Integer identifiant) {
        sortieService.deleteSortie(sortieService.getSortieById(identifiant));
    }

    @Operation(summary = "Ajouter un utilisateur à une sortie")
    @RequestMapping(path = "/participant", method = RequestMethod.PUT)
    @Valid
    public void addParticipant(@RequestParam(value = "id") Integer identifiant, @RequestParam(value="username") String username) {
        sortieService.addUserToSortie(username, identifiant);
    }

    @Operation(summary = "Retirer un utilisateur d'une sortie")
    @RequestMapping(path = "/participant/remove", method = RequestMethod.DELETE)
    public void removeParticipant(@RequestParam(value = "id") Integer identifiant, @RequestParam(value="username") String username) {
        sortieService.removeUserToSortie(username, identifiant);
    }
}
