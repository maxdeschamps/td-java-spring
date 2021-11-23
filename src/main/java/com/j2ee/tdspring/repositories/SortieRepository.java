package com.j2ee.tdspring.repositories;

import com.j2ee.tdspring.entities.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Integer> {
}
