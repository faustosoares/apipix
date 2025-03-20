package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;

public record RequestCobrancaDTO(

        @NotNull String chave
) {
}
