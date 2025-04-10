package br.com.fbms.apipix.models;

import br.com.fbms.apipix.enums.TipoCobranca;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Embeddable
public class Location {

    private Integer id;

    private String location;

    private TipoCobranca tipoCob;

    private OffsetDateTime criacao;
}
