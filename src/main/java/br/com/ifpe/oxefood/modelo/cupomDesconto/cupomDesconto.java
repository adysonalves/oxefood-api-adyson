package br.com.ifpe.oxefood.modelo.cupomDesconto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cupom_desconto")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class cupomDesconto extends EntidadeAuditavel {

    @Column
    private String codigoDesconto;

    @Column
    private Double percentualDesconto;

    @Column
    private Double valorDesconto;

    @Column
    private Double valorMinimoPedidoPermitido;

    @Column
    private Integer quantidadeMaximaUso;

    @Column
    private LocalDate inicioVigencia;

    @Column
    private LocalDate fimVigencia;

}
