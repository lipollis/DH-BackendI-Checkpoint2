package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.dto.DentistaDTO;
import com.example.ClinicaOdontologica.persistence.entity.DentistaEntity;
import com.example.ClinicaOdontologica.persistence.repository.DentistaRepository;
import com.example.ClinicaOdontologica.service.OdontoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // INSTANCIAR INTERFACE
public class DentistaServiceImpl implements OdontoService<DentistaDTO> {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(DentistaServiceImpl.class);

    // VARIÁVEL DO REPOSITORY
    private DentistaRepository dentistaRepository;

    // CONSTRUTOR
    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository){
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public DentistaDTO salvar(DentistaDTO dentista) {
        // CONVERSÃO DO DENTISTA PARA DENTISTA DTO:
        DentistaEntity dentistaEntity = new DentistaEntity(dentista);

        return new DentistaDTO(dentistaRepository.save(dentistaEntity));
    }

    @Override
    public DentistaDTO buscarId(Integer id) {
        return new DentistaDTO(dentistaRepository.getById(id));
    }

    @Override
    public List<DentistaDTO> buscarTodos() {
        List<DentistaEntity> dentistaEntityList = new ArrayList<>();
        dentistaEntityList.addAll(dentistaRepository.findAll());//salvando dentro da lista
        List<DentistaDTO> dentistaDTOList = new ArrayList<>();
        //percorrer a lista
        dentistaEntityList.forEach(dentistaEntity -> {
            DentistaDTO dentistaDTO = new DentistaDTO(dentistaRepository.getById(dentistaEntity.getId()));
            dentistaDTOList.add(dentistaDTO);
        });
        return dentistaDTOList;
    }

    @Override
    public DentistaDTO atualizar(DentistaDTO dentista) {
        // BUSCA O DENTISTA
        DentistaEntity dentistaEntity = dentistaRepository.getById(dentista.getId());

        if(dentista.getNome() != null && dentista.getSobrenome() != null){
            dentistaEntity.setNome(dentista.getNome());
            dentistaEntity.setSobrenome(dentista.getSobrenome());
        }
        DentistaDTO dentistaAtual = new DentistaDTO(dentistaRepository.saveAndFlush(dentistaEntity));
        return dentistaAtual;
    }

    @Override
    public void deletar(Integer id) {
        if(dentistaRepository.getById(id) == null) {
            logger.info("Registro não encontrado. ");
        }
        dentistaRepository.deleteById(id);
    }
}

