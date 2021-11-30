package com.example.ClinicaOdontologica.persistence.repository;

import com.example.ClinicaOdontologica.persistence.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// COMUNICAÇÃO COM O BANCO
public interface DentistaRepository extends JpaRepository<DentistaEntity,Integer> {
}
