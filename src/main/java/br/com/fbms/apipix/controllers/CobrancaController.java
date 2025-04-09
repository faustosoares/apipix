package br.com.fbms.apipix.controllers;

import br.com.fbms.apipix.dto.RequestCobrancaDTO;
import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.services.CobrancaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/cob")
public class CobrancaController {

    private final CobrancaService cobrancaService;


    @PutMapping(path = "/{txid}")
    public ResponseEntity<ResponseCobrancaDTO> criarCobranca(@PathVariable("txid") String txId,
                                                             @RequestBody RequestCobrancaDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cobrancaService.criar(txId, request));
    }

    @GetMapping
    public String consultar(){
        return "OLLAAA";
    }

    @PostMapping
    public void criarNovo(){

    }
}
