package com.j2ee.tdspring.services;

import com.j2ee.tdspring.entities.Sortie;
import com.j2ee.tdspring.entities.User;
import com.j2ee.tdspring.repositories.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {
    @Autowired
    private SortieRepository sortieRepository;
    @Autowired
    private UserService userService;

    public Sortie createOrUpdate(Sortie sortie) {
        return sortieRepository.save(sortie);
    }

    public Sortie getSortieById(Integer identifiant) {
        return sortieRepository.findById(identifiant).orElse(null);
    }

    public List<Sortie> getAllSorties() {
        return sortieRepository.findAll();
    }

    public void deleteSortie(Sortie sortie) {
        sortieRepository.delete(sortie);
    }

    public void addUserToSortie(String username, Integer identifiant) {
        User user = userService.getUserById(username);
        Sortie sortie = this.getSortieById(identifiant);

        sortie.addParticipant(user);
        sortieRepository.save(sortie);
    }

    public void removeUserToSortie(String username, Integer identifiant) {
        User user = userService.getUserById(username);
        Sortie sortie = this.getSortieById(identifiant);

        sortie.removeParticipant(user);
        sortieRepository.save(sortie);
    }

}