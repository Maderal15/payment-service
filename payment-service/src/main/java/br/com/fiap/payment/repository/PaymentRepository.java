package br.com.fiap.payment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.payment.model.PaymentDTO;

@Repository
public class PaymentRepository {

    private List<PaymentDTO> payments;

    public PaymentRepository(){
        payments = new ArrayList<>();
     /*   PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setIdTransacao(1);
        paymentDTO.setNumeroCartao(1254423l);
        paymentDTO.setValidadeCartao(LocalDate.now());
        paymentDTO.setValorCompra(new BigDecimal("1523"));
        paymentDTO.setBandeira("Dinnners");
        payments.add(paymentDTO);*/

    }

    public PaymentDTO findById(Integer id) {
    	for (PaymentDTO paymentDTO : payments) {
    		if(paymentDTO.getIdTransacao().equals(id)) {
    			return paymentDTO;
    		
    		} 
			
		}
		return null;
		
    }

    public PaymentDTO save(PaymentDTO paymentDTO){
    	paymentDTO.setIdTransacao((payments.size()+1));
        this.payments.add(paymentDTO);
        return paymentDTO;
    }


    public PaymentDTO update(Integer id, PaymentDTO paymentDTO){
        PaymentDTO payment = findById(id);
        int indice = payments.indexOf(payment);
        paymentDTO.setIdTransacao(payment.getIdTransacao());
        payments.set(indice, paymentDTO);
        return paymentDTO;
    }

    public PaymentDTO delete(Integer id){
        PaymentDTO payment = findById(id);
        payments.remove(payment);
        return payment;
    }

}
