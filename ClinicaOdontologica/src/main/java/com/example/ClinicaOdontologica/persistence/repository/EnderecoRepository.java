package com.example.ClinicaOdontologica.persistence.repository;

import com.example.ClinicaOdontologica.persistence.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// COMUNICAÇÃO COM O BANCO
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {
}
