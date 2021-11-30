package com.example.ClinicaOdontologica.persistence.entity;


import com.example.ClinicaOdontologica.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "endereco")// IDENTIFICA QUE É UMA TABELA
public class EnderecoEntity {

    @Id
    @SequenceGenerator(name = "sequenceEndereco", sequenceName = "sequenceEndereco", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceEndereco")
    @Column(name = "id")
    private Integer id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cidade")
    private String cidade;

    // CONSTRUTOR VAZIO
    public EnderecoEntity () {}

    // MÉTODO CONSTRUTOR - COMPARTILHAR AS INFORMAÇÕES - CONVERSÃO ENTITY E DTO
    public EnderecoEntity(EnderecoDTO endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
    }

    // toString
    @Override
    public String toString() {
        return "EnderecoEntity{" +
               "id=" + id +
               ", rua='" + rua + '\'' +
               ", numero='" + numero + '\'' +
               ", cidade='" + cidade + '\'' +
               '}';
    }
}
