package br.com.fbms.apipix.dto;

import br.com.fbms.apipix.enums.StatusCobranca;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record ResponseCobrancaDTO(

        @NotNull CalendarioDTO calendario,

        @NotNull @Pattern(regexp = "[a-zA-Z0-9]{26,35}") String txId,

        @NotNull Integer revisao,

        LocationDTO loc,

        String location,

        @NotNull StatusCobranca status,

        @NotNull ValorDTO valor,

        @Size(max = 512) String pixCopiaECola,

        @NotNull @Size(max = 77) String chave,

        @Size(max = 140) String solicitacaoPagador,

        List<InformacaoAdicionalDTO> infoAdicionais) {
}
