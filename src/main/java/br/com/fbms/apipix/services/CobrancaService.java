package br.com.fbms.apipix.services;

import br.com.fbms.apipix.dto.CalendarioDTO;
import br.com.fbms.apipix.dto.LocationDTO;
import br.com.fbms.apipix.dto.RequestCobrancaDTO;
import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.enums.TipoCobranca;
import br.com.fbms.apipix.models.Calendario;
import br.com.fbms.apipix.models.EntCobranca;
import br.com.fbms.apipix.models.Location;
import br.com.fbms.apipix.repositories.CobrancaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Random;

@AllArgsConstructor
@Service
public class CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    public ResponseCobrancaDTO criar(String txId, RequestCobrancaDTO request) {

        var cobranca = cobrancaRepository.findById(txId).orElse(null);

        cobranca = EntCobranca.builder()
                .txId(txId)
                .calendario(Calendario.builder()
                        .expiracao(request.calendario().expiracao())
                        .criacao(OffsetDateTime.now()).build())
                .chave(request.chave())
                .revisao(cobranca != null ? cobranca.getRevisao() + 1 : 0)
                .location(request.location())
                .loc(Location.builder()
                        .id(new Random().nextInt(10000))
                        .criacao(OffsetDateTime.now().minusHours(2))
                        .tipoCob(TipoCobranca.COB)
                        .location(request.location())
                        .build())
                .build();

        cobrancaRepository.save(cobranca);

        return ResponseCobrancaDTO.builder()
                .txId(cobranca.getTxId())
                .calendario(CalendarioDTO.builder()
                        .criacao(cobranca.getCalendario().getCriacao())
                        .expiracao(cobranca.getCalendario().getExpiracao())
                        .build())
                .chave(cobranca.getChave())
                .revisao(cobranca.getRevisao())
                .location(cobranca.getLocation())
                .loc(LocationDTO.builder()
                        .criacao(cobranca.getLoc().getCriacao())
                        .id(cobranca.getLoc().getId())
                        .location(cobranca.getLoc().getLocation())
                        .tipoCob(cobranca.getLoc().getTipoCob())
                        .build())
                .build();
    }
}
