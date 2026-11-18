package com.seduc2.gta.repositories;

import com.seduc2.gta.entities.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository <Missao, Long> {
}
