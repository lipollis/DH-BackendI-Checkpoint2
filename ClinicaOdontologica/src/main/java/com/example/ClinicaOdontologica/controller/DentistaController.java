package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.dto.DentistaDTO;
import com.example.ClinicaOdontologica.dto.PacienteDTO;
import com.example.ClinicaOdontologica.service.impl.DentistaServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buscarTodos")
    public ResponseEntity buscarTodos(){
        logger.info("Buscando todos os registros de dentista...");
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @PutMapping("/atualizar")
    public ResponseEntity atualizar(@RequestBody DentistaDTO dentistaDTO){
        logger.info("Registro atualizado.");
        return ResponseEntity.ok(dentistaService.atualizar(dentistaDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody Integer id) {
        logger.info("Registro deletado.");
        dentistaService.deletar(id);
    }

}
