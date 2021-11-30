package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // INSTANCIAR INTERFACE
public class EnderecoServiceImpl implements OdontoService<EnderecoServiceImpl> {


    @Override
    public EnderecoServiceImpl salvar(EnderecoServiceImpl enderecoService) {
        return null;
    }

    @Override
    public EnderecoServiceImpl buscarId(Integer id) {
        return null;
    }

    @Override
    public List<EnderecoServiceImpl> buscarTodos() {
        return null;
    }

    @Override
    public EnderecoServiceImpl atualizar(EnderecoServiceImpl enderecoService) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }
}

