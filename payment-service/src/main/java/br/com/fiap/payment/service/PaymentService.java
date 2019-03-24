package br.com.fiap.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return paymentRepository.findById(id);
    }

    public PaymentDTO save(PaymentDTO paymentDTO){
        return paymentRepository.save(paymentDTO);
    }


    public PaymentDTO update(Integer id, PaymentDTO paymentDTO){
        return paymentRepository.update(id, paymentDTO);
    }

    public PaymentDTO delete(Integer id){
        return paymentRepository.delete(id);
    }

}
