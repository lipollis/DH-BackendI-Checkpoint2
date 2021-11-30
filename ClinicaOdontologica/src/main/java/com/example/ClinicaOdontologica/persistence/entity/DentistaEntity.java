package com.example.ClinicaOdontologica.persistence.entity;


import com.example.ClinicaOdontologica.dto.DentistaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "dentista")// IDENTIFICA QUE É UMA TABELA
public class DentistaEntity {

    @Id // INDICAÇÃO DO ID DA TABELA
    @SequenceGenerator(name = "sequenceDentista", sequenceName = "sequenceDentista", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceDentista")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "matricula")
    private String numMatricula;

    // CONSTRUTOR VAZIO
    public DentistaEntity(){}

    // CONSTRUTOR
    public DentistaEntity(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.numMatricula = dentistaDTO.getNumMatricula();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
    }

    // toString
    @Override
    public String toString() {
        return "DentistaEntity{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", numMatricula='" + numMatricula + '\'' +
               '}';
    }
}


