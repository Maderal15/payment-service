package br.com.fiap.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.payment.exception.PaymentNotFoundException;
import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.repository.PaymentRepository;

@Service
public class PaymentService {


    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    
    public PaymentDTO findById(Integer id) {
    	PaymentDTO paymentDTO =  paymentRepository.findById(id);
    	
    	  if(paymentDTO == null){
         	 throw new PaymentNotFoundException("Id não encontrado");	
         }

        return paymentDTO;
    }

    public PaymentDTO save(PaymentDTO paymentDTO){
    	 if(paymentDTO.getNumeroCartao() == null){
         	throw new PaymentNotFoundException("Erro para cadastrar");	
         }

        return paymentRepository.save(paymentDTO);
    }


    public PaymentDTO update(Integer id, PaymentDTO paymentDTO){
    	 if(paymentDTO.getNumeroCartao() == null){
          	throw new PaymentNotFoundException("Erro para atualizar");	
          }

        return paymentRepository.update(id, paymentDTO);
    }

    public PaymentDTO delete(Integer id){
        return paymentRepository.delete(id);
    }

}
