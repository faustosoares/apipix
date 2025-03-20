package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record CalendarioDTO(

        @NotNull Integer expiracao,

        @NotNull OffsetDateTime criacao
) {
}
