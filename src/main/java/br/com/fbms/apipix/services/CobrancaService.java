package br.com.fbms.apipix.services;

import br.com.fbms.apipix.dto.RequestCobrancaDTO;
import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.models.EntCobranca;
import br.com.fbms.apipix.repositories.CobrancaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CobrancaService {

    private final CobrancaRepository cobrancaRepository;

    public ResponseCobrancaDTO criar(String txId, RequestCobrancaDTO request) {

        var cobranca = EntCobranca.builder()
                .txId(txId)
                .chave(request.chave())
                .build();

        cobrancaRepository.save(cobranca);

        return ResponseCobrancaDTO.builder()
                .txId(cobranca.getTxId())
                .chave(cobranca.getChave())
                .build();
    }
}
