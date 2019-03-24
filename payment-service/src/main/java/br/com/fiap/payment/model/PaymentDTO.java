package br.com.fiap.payment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    private Integer idTransacao;
    private Integer numeroCartao;
    private LocalDate validadeCartao;
    private BigDecimal valorCompra;
    private String bandeira;
}
