package com.ynov.j2eetdspring.controllers;

import com.ynov.j2eetdspring.entities.Sortie;
import com.ynov.j2eetdspring.services.SortieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sorties")
public class SortieController {

    @Autowired
    private SortieService sortieService;

    @Operation(summary = "Récupération d'une sortie par son identifiant")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Sortie get(@PathVariable(name = "id") Long id_sortie){
        return sortieService.getSortieById(id_sortie);
    }

    @Operation(summary = "Création ou Modification d'une sortie")
    @RequestMapping(method = RequestMethod.PUT)
    public Sortie createOrUpdate(@RequestBody Sortie sortie){
        return sortieService.createOrUpdate(sortie);
    }

    @Operation(summary = "Récupération de toutes les sorties")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<Sortie> getAllSorties() {
        return sortieService.getAllSorties();
    }

    @Operation(summary = "Suppression d'une sortie à partir de son identifiant")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteSortie(@PathVariable(value = "id") Long id) {
        sortieService.deleteSortieById(id);
    }

    @Operation(summary = "Récupération de tous les sorties dans une page")
    @RequestMapping(method = RequestMethod.GET)
    public Page<Sortie> getSorties(Pageable pageable) {
        return sortieService.getSortiesWithPaging(pageable);
    }

}
