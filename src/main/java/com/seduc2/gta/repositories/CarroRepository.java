package com.seduc2.gta.repositories;

import com.seduc2.gta.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository <Veiculo, Long> {
}
