package br.com.fiap.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
	
	@ApiModelProperty(notes = "id da transação")
    private Integer idTransacao;
	
	@ApiModelProperty(notes = "número do cartão", required = true)
    private Integer numeroCartao;
	
	@ApiModelProperty(notes = "data da valida do cartão", required = true)
    private LocalDate validadeCartao;
    
	@ApiModelProperty(notes = "valor da compra", required = true)
	private BigDecimal valorCompra;
    
	@ApiModelProperty(notes = "bandeira", required = true)
	private String bandeira;
 
}
