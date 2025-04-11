package br.com.fbms.apipix.services;

import br.com.fbms.apipix.dto.RequestCobrancaDTO;
import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.enums.TipoCobranca;
import br.com.fbms.apipix.mapper.CobrancaMapper;
import br.com.fbms.apipix.models.Calendario;
import br.com.fbms.apipix.models.EntCobranca;
import br.com.fbms.apipix.models.Location;
import br.com.fbms.apipix.repositories.CobrancaRepository;
import br.com.fbms.apipix.util.PixUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Random;

@AllArgsConstructor
@Service
public class CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    private final CobrancaMapper mapper;

    public ResponseCobrancaDTO criar(String txId, RequestCobrancaDTO request) {

        var cobranca = cobrancaRepository.findById(txId).orElse(null);


        String copiaECola = PixUtils.gerarPixCopiaECola(
                request.chave(),
                "Jose da Silva", //Definir mediante obtencao do token da conta
                "Aracaju",
                String.valueOf(request.valor().original()),
                txId);


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
                .solicitacaoPagador(request.solicitacaoPagador())
                .pixCopiaECola(copiaECola)
                .build();

        cobrancaRepository.save(cobranca);

        return mapper.toResponseCobrancaDTO(cobranca);
    }
}
