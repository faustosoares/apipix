package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InformacaoAdicionalDTO(

        @NotNull String nome,

        @NotNull @Size(max = 140) String valor) {
}
