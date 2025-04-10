package br.com.fbms.apipix.models;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class Valor {

    private BigDecimal original;

    private Integer modalidadeAlteracao;
}
