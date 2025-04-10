package br.com.fbms.apipix.dto;

import br.com.fbms.apipix.enums.TipoCobranca;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record LocationDTO(

        @NotNull Integer id,

        @NotNull @Size(max = 77) String location,

        @NotNull TipoCobranca tipoCob,

        @NotNull @PastOrPresent OffsetDateTime criacao) {
}
