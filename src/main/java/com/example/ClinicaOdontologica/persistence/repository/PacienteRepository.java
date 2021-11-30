package com.example.ClinicaOdontologica.persistence.repository;

import com.example.ClinicaOdontologica.persistence.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// COMUNICAÇÃO COM O BANCO
public interface PacienteRepository extends JpaRepository<PacienteEntity,Integer> {
}
