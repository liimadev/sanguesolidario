package com.liimadev.sanguesolidario.repositories;

import com.liimadev.sanguesolidario.models.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Integer> {
}
