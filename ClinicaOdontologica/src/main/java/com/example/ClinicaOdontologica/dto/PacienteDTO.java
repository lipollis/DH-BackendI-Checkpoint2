package com.example.ClinicaOdontologica.dto;

import com.example.ClinicaOdontologica.persistence.entity.PacienteEntity;
import lombok.Getter;
import lombok.Setter;


@Getter // ASSINATURA LOMBOK
@Setter
public class PacienteDTO {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private EnderecoDTO endereco; // CHAVE ESTRANGEIRA DO BANCO

    // CONSTRUTOR VAZIO
    public PacienteDTO () {}

    // CONSTRUTOR PARA A CONVERSÃO PACIENTE EM DTO
    public PacienteDTO(PacienteEntity paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = new EnderecoDTO(paciente.getEndereco()); //para preencher o recebido de endereço
    }

    // toString
    @Override
    public String toString() {
        return "PacienteDTO{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", endereco=" + endereco +
               '}';
    }
}
