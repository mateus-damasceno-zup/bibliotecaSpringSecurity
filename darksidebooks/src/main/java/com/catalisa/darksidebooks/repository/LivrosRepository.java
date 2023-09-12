package com.catalisa.darksidebooks.repository;

import com.catalisa.darksidebooks.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<LivroModel,Long> {
}
