package br.com.fbms.apipix.models;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Calendario {

    private Integer expiracao;

    private OffsetDateTime criacao;
}
