package com.seduc2.gta.repositories;

import com.seduc2.gta.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository <Personagem,Long> {
}
