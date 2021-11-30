package com.example.ClinicaOdontologica.dto;

import com.example.ClinicaOdontologica.persistence.entity.EnderecoEntity;
import lombok.Getter;
import lombok.Setter;


@Getter // ASSINATURA LOMBOK
@Setter
public class EnderecoDTO {
    // ATRIBUTOS
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;

    // CONSTRUTOR VAZIO
    public EnderecoDTO () {}

    // MÉTODO CONSTRUTOR - COMPARTILHAR AS INFORMAÇÕES - CONVERSÃO
    public EnderecoDTO(EnderecoEntity endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
    }

    // toString
    @Override
    public String toString() {
        return "EnderecoDTO{" +
               "id=" + id +
               ", rua='" + rua + '\'' +
               ", numero='" + numero + '\'' +
               ", cidade='" + cidade + '\'' +
               '}';
    }
}
