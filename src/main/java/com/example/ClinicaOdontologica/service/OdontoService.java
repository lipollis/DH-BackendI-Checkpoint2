package com.example.ClinicaOdontologica.service;

import java.util.List;
import java.util.Map;

// INTERFACE USANDO O 'T' PARA SERVIR PARA TODOS OS SERVICES
public interface OdontoService<T> {
    T salvar(T t);
    T buscarId(Integer id);
    List<T> buscarTodos();
    //Map<Integer, T> buscarTodos();
    T atualizar(T t);
    void deletar(Integer id);
}
