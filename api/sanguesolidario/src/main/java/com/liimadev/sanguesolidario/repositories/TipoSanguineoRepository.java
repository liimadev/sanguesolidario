package com.liimadev.sanguesolidario.repositories;

import com.liimadev.sanguesolidario.models.TipoSanguineo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSanguineoRepository extends JpaRepository<TipoSanguineo, Integer> {
}
