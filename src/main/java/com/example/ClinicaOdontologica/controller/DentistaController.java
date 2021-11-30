package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.dto.DentistaDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ASSINATURAS
@RestController
@RequestMapping("/dentista")
public class DentistaController {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(DentistaController.class);

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody DentistaDTO dentista){
        ResponseEntity<String> response = null;
        if(dentistaService.salvar(dentista) != null){
            logger.info("Dentista " + dentista.getNome() + " " + dentista.getSobrenome() + " salvo!");
            response = ResponseEntity.ok("Dentista salvo.");}
        else{
            logger.info("Ops, tente novamente.");
            response = ResponseEntity.internalServerError().body("Algo de errado não está certo");}
                //ResponseEntity.ok(dentistaService.salvar(dentista));
        return response;
    }

    @GetMapping("/buscar/{id}")//
    public ResponseEntity buscarId(@PathVariable Integer id) {
        DentistaDTO dentista = dentistaService.buscarId(id);

        // TRATAMENTO DE ERRO PARA A MENSAGEM EXIBIDA AO USUÁRIO
        if(dentista != null){
            logger.info("Buscando dentista...");
            return ResponseEntity.ok(dentistaService.buscarId(id));}

        //ResponseEntity.status(HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body("Dentista não encontrado");
    }

    @GetMapping("/buscartodos")
    public ResponseEntity buscarTodos(){
        List<DentistaDTO> dentistaDTOList = dentistaService.buscarTodos();
        logger.info("Buscando todos os registros de dentista...");
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @PutMapping("/atualizar")
    public ResponseEntity atualizar(@RequestBody DentistaDTO dentista){
        DentistaDTO dentistaAtual = dentistaService.atualizar(dentista);
        if(dentistaAtual !=null){
            logger.info("Registro atualizado.");
            return ResponseEntity.ok(dentistaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){

        ResponseEntity<String> response = null;

        DentistaDTO dentistaDeletado = dentistaService.buscarId(id);
        if(dentistaDeletado != null){
            logger.info("Registro deletado. ");
            dentistaService.deletar(id);
        } else{
            logger.info("Registro não encontrado. ");
            response = ResponseEntity.ok("Registro não encontrado.");
        }
        return response;
    }

}
