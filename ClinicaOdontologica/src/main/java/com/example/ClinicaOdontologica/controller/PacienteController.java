package com.example.ClinicaOdontologica.controller;


import com.example.ClinicaOdontologica.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.PacienteServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ASSINATURAS
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody PacienteDTO paciente){
        ResponseEntity<String> response = null;
        if(pacienteService.salvar(paciente) != null){
            logger.info("Paciente " + paciente.getNome() + " " + paciente.getSobrenome() + " salvo!");
            response = ResponseEntity.ok("Paciente salvo.");}
        else{
            logger.info("Ops, tente novamente.");
            response = ResponseEntity.internalServerError().body("Algo de errado não está certo");}
        return response;
    }

    @GetMapping("/buscar/{id}")//
    public ResponseEntity buscarId(@PathVariable Integer id) {
        PacienteDTO paciente = pacienteService.buscarId(id);

        // TRATAMENTO DE ERRO PARA A MENSAGEM EXIBIDA AO USUÁRIO
        if(paciente != null){
            logger.info("Buscando paciente id " + paciente.getId() + "...");
            return ResponseEntity.ok(pacienteService.buscarId(id));}

        //ResponseEntity.status(HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }

    @GetMapping("/buscartodos")
    public ResponseEntity buscarTodos(){
        List<PacienteDTO> pacienteDTOList = pacienteService.buscarTodos();
        logger.info("Buscando todos os registros de paciente...");
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping("/atualizar")
    public ResponseEntity atualizar(@RequestBody PacienteDTO paciente){
        PacienteDTO pacienteAtual = pacienteService.atualizar(paciente);
        if(pacienteAtual !=null){
            logger.info("Registro atualizado.");
            return ResponseEntity.ok(pacienteAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    //public void deletar(@PathVariable Integer id) {
        public ResponseEntity<String> deletar(@PathVariable Integer id){

        ResponseEntity<String> response = null;

        PacienteDTO pacienteDeletado = pacienteService.buscarId(id);
        if(pacienteDeletado != null){
            logger.info("Registro deletado. ");
            pacienteService.deletar(id);
        } else{
            logger.info("Registro não encontrado. ");
            response = ResponseEntity.ok("Registro não encontrado.");
        }
            return response;

    }
}
