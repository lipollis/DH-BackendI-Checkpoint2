package com.example.ClinicaOdontologica.persistence.entity;


import com.example.ClinicaOdontologica.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "paciente")// IDENTIFICA QUE É UMA TABELA
public class PacienteEntity {

    @Id // INDICAÇÃO DO ID DA TABELA
    @SequenceGenerator(name = "sequencePaciente", sequenceName = "sequencePaciente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePaciente")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // RELACIONAMENTO 1:1
    // CASCADE - QUANDO DELETAR O PACIENTE TAMBÉM DELETARÁ O ENDEREÇO OU QUALQUER OUTRA CLASSE QUE SE RELACIONAR COM ENDEREÇO
    @JoinColumn(name = "endereco")
    private EnderecoEntity endereco;


    // CONSTRUTOR VAZIO - PARA QUANDO SOBREESCREVER
    public PacienteEntity(){}

    // CONSTRUTOR PARA A CONVERSÃO DTO EM PACIENTE
    public PacienteEntity(PacienteDTO paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = new EnderecoEntity(paciente.getEndereco());
    }

    // toString

    @Override
    public String toString() {
        return "PacienteEntity{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", endereco=" + endereco +
               '}';
    }
}
