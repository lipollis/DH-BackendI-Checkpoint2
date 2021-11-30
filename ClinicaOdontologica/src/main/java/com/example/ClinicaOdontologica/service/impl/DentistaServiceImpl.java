package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.dto.DentistaDTO;
import com.example.ClinicaOdontologica.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // INSTANCIAR INTERFACE
public class DentistaServiceImpl implements OdontoService<DentistaDTO> {


    @Override
    public DentistaDTO salvar(DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public DentistaDTO buscarId(Integer id) {
        return null;
    }

    @Override
    public List<DentistaDTO> buscarTodos() {
        return null;
    }

    @Override
    public DentistaDTO atualizar(DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }
}

