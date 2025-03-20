package br.com.fbms.apipix.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {


    @GetMapping("hello")
    public ResponseEntity<Map<String,Object>> hello() {
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("campo", "Hello");

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(resposta);
    }
}
