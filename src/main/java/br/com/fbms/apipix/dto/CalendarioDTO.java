package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record CalendarioDTO(

        @NotNull Integer expiracao,

        OffsetDateTime criacao
) {
}
