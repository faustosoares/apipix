package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ValorDTO(

        @NotNull BigDecimal original,

        Integer modalidadeAlteracao) {
}
