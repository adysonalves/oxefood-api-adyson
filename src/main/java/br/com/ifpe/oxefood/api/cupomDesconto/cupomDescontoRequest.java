package br.com.ifpe.oxefood.api.cupomDesconto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cupomDesconto.cupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class cupomDescontoRequest {

   private String codigoDesconto;
   private Double percentualDesconto;
   private Double valorDesconto;
   private Double valorMinimoPedidoPermitido;
   private Integer quantidadeMaximaUso;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate inicioVigencia;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate fimVigencia;

   public cupomDesconto build() {

       return cupomDesconto.builder()
               .codigoDesconto(codigoDesconto)
               .percentualDesconto(percentualDesconto)
               .valorDesconto(valorDesconto)
               .valorMinimoPedidoPermitido(valorMinimoPedidoPermitido)
               .quantidadeMaximaUso(quantidadeMaximaUso)
               .inicioVigencia(inicioVigencia)
               .fimVigencia(fimVigencia)
               .build();
   }
}

