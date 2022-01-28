package com.ynov.j2eetdspring.services;

import com.ynov.j2eetdspring.entities.Sortie;
import com.ynov.j2eetdspring.repositories.SortieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {
    private SortieRepository sortieRepository;

    public Sortie createOrUpdate(Sortie sortie){
        return sortieRepository.save(sortie);
    }

    public Sortie getSortieById(Long id){
        return sortieRepository.findById(id).orElse(null);
    }

    public List<Sortie> getAllSorties(){
        return sortieRepository.findAll();
    }

    public void deleteSortieById(Long id){
        sortieRepository.deleteById(id);
    }

    public Page<Sortie> getSortiesWithPaging(Pageable pageable){
        return sortieRepository.findAll(pageable);
    }
}
