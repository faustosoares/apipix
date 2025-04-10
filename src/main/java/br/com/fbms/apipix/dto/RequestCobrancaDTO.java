package br.com.fbms.apipix.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RequestCobrancaDTO(

        @NotNull CalendarioDTO calendario,

        @NotNull String chave,

        @NotNull ValorDTO valor,

        String solicitacaoPagador,

        String location,

        List<InformacaoAdicionalDTO> infoAdicionais) {
}
