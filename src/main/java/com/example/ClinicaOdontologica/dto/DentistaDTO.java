package com.example.ClinicaOdontologica.dto;

import com.example.ClinicaOdontologica.persistence.entity.DentistaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter // ASSINATURA LOMBOK
@Setter
public class DentistaDTO {
    private Integer id;
    private String numMatricula;
    private String nome;
    private String sobrenome;

    // CONSTRUTOR VAZIO
    public DentistaDTO () {}

    public DentistaDTO(DentistaEntity dentistaEntity) {
        this.id = dentistaEntity.getId();
        this.numMatricula = dentistaEntity.getNumMatricula();
        this.nome = dentistaEntity.getNome();
        this.sobrenome = dentistaEntity.getSobrenome();
    }

    // toString
    @Override
    public String toString() {
        return "DentistaDTO{" +
               "id=" + id +
               ", numMatricula='" + numMatricula + '\'' +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               '}';
    }
}
