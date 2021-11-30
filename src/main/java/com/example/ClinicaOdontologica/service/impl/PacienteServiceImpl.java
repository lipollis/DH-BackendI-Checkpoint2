package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.controller.PacienteController;
import com.example.ClinicaOdontologica.dto.PacienteDTO;
import com.example.ClinicaOdontologica.persistence.entity.EnderecoEntity;
import com.example.ClinicaOdontologica.persistence.entity.PacienteEntity;
import com.example.ClinicaOdontologica.persistence.repository.EnderecoRepository;
import com.example.ClinicaOdontologica.persistence.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.OdontoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // INSTANCIAR INTERFACE
public class PacienteServiceImpl implements OdontoService<PacienteDTO> {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(PacienteServiceImpl.class);

    // VARIÁVEL DO REPOSITORY
    private PacienteRepository pacienteRepository;
    private EnderecoRepository enderecoRepository;

    // CONSTRUTOR
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, EnderecoRepository enderecoRepository){
        this.pacienteRepository = pacienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public PacienteDTO salvar(PacienteDTO paciente) {
        // CONVERSÃO DO PACIENTE PARA PACIENTE DTO:
        PacienteEntity pacienteEntity = new PacienteEntity(paciente);
        // BUSCA O ENDEREÇO DENTRO DE ENTITY, MANDA PARA REPOSITORY, O QUE RETORNA SOBREESCREVE ENTITY
        pacienteEntity.setEndereco(enderecoRepository.saveAndFlush(pacienteEntity.getEndereco())); //salvar o endereço


        return new PacienteDTO(pacienteRepository.save(pacienteEntity));
    }

    @Override
    public PacienteDTO buscarId(Integer id) {
        return new PacienteDTO(pacienteRepository.getById(id));
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        //pacienteRepository.findAll() salva dentro de uma lista de paciente entity, percorre a lista e converte em dto, numa outra lista
        List<PacienteEntity> pacienteEntityList = new ArrayList<>();
        pacienteEntityList.addAll(pacienteRepository.findAll());//salvando dentro da lista
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();
        //percorrer a lista
        pacienteEntityList.forEach(pacienteEntity -> {
            PacienteDTO pacienteDTO = new PacienteDTO(pacienteRepository.getById(pacienteEntity.getId()));
            pacienteDTOList.add(pacienteDTO);
        });

        return pacienteDTOList;
    }

    @Override
    public PacienteDTO atualizar(PacienteDTO paciente) {
        // BUSCA OS PACIENTES QUE NÃO POSSUEM O ID E RETORNA NULO
        PacienteEntity pacienteEntity = pacienteRepository.getById(paciente.getId());
        if(pacienteEntity == null){
            return null;
        }

        // CASO O PACIENTE POSSUA O ID, SET ESSE VALOR, COMPARA COM ENDEREÇO QUAL O CORRESPONDENTE
        paciente.setId(paciente.getId());
        EnderecoEntity endereco = enderecoRepository.getById(pacienteEntity.getId());
        // ATUALIZA EM PACIENTE O ENDEREÇO
        paciente.getEndereco().setId(endereco.getId());
        enderecoRepository.saveAndFlush(pacienteEntity.getEndereco());
        PacienteEntity pacienteAtual = new PacienteEntity(paciente);
        //pacienteRepository.saveAll(pacienteRepository.findAllById(id)),pacienteAtual);
        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        if(pacienteRepository.getById(id) == null) {
            logger.info("Registro não encontrado. ");
        }
        pacienteRepository.deleteById(id);
    }
}
