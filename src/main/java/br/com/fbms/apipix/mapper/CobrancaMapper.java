package br.com.fbms.apipix.mapper;


import br.com.fbms.apipix.dto.ResponseCobrancaDTO;
import br.com.fbms.apipix.models.EntCobranca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CobrancaMapper {

    ResponseCobrancaDTO toResponseCobrancaDTO(EntCobranca cobranca);
}
