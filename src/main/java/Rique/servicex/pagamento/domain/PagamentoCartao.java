package Rique.servicex.pagamento.domain;


import Rique.servicex.ordemservico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoCartao")
public class PagamentoCartao extends Pagamento{
    private static final long serialVersionUID = 1L;

    @Column(name = "NUMERO_PARCELAS")
    private Integer numeroParcelas;

    public PagamentoCartao(){}

    public PagamentoCartao(Integer idPagamento, StatusPagamento statusPagmento, OrdemServico ordemServico, Integer numeroParcelas) {
        super(idPagamento, statusPagmento, ordemServico);
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoCartao(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
