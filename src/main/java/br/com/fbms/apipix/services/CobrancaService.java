package br.com.fbms.apipix.services;

import br.com.fbms.apipix.dto.CalendarioDTO;
import br.com.fbms.apipix.dto.RequestCobrancaDTO;
import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.models.Calendario;
import br.com.fbms.apipix.models.EntCobranca;
import br.com.fbms.apipix.repositories.CobrancaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    public ResponseCobrancaDTO criar(String txId, RequestCobrancaDTO request) {

        var cobranca = EntCobranca.builder()
                .txId(txId)
                .calendario(Calendario.builder()
                        .expiracao(request.calendario().expiracao())
                        .criacao(OffsetDateTime.now()).build())
                .chave(request.chave())
                .build();

        cobrancaRepository.save(cobranca);

        return ResponseCobrancaDTO.builder()
                .txId(cobranca.getTxId())
                .calendario(CalendarioDTO.builder()
                        .criacao(cobranca.getCalendario().getCriacao())
                        .expiracao(cobranca.getCalendario().getExpiracao())
                        .build())
                .chave(cobranca.getChave())
                .build();
    }
}
