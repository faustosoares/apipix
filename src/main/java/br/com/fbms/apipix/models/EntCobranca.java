package br.com.fbms.apipix.models;

import br.com.fbms.apipix.enums.StatusCobranca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_COBRANCA")
public class EntCobranca {

    @Id
    private String txId;

    @Column(name = "CHAVE", columnDefinition = "VARCHAR(77)")
    private String chave;

    @Embedded
    @AttributeOverride(name = "expiracao", column = @Column(name = "EXPIRACAO_CALENDARIO", columnDefinition = "INTEGER"))
    @AttributeOverride(name = "criacao", column = @Column(name = "DT_CRIACAO_CALENDARIO", columnDefinition = "DATETIME"))
    private Calendario calendario;

    @Column(name = "REVISAO", columnDefinition = "INTEGER")
    private Integer revisao;

    //private Location loc;

    //String location;

    @Column(name = "STATUS", columnDefinition = "VARCHAR(30)")
    @Enumerated
    StatusCobranca status;

    //private Valor valor;

    @Column(name = "PIX_COPIA_E_COLA", columnDefinition = "VARCHAR(512)")
    String pixCopiaECola;

    @Column(name = "SOLICITACA_PAGADOR", columnDefinition = "VARCHAR(140)")
    String solicitacaoPagador;

    //List<InformacaoAdicional> infoAdicionais;

    //metodos
}
