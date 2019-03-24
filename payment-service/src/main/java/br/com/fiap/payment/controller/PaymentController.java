package br.com.fiap.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/payment", produces = "application/json")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @GetMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable(value="idTransacao") Integer idTransacao){

        System.out.printf("findById %s", idTransacao);

        PaymentDTO paymentDTO = paymentService.findById(idTransacao);

        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid PaymentDTO paymentDTO){

        paymentDTO = paymentService.save(paymentDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("{ \"payment\" : \"/payment/"+paymentDTO.getIdTransacao()+ "\"}");
    }


    @PutMapping("/{idTransacao}")
    public ResponseEntity update(@PathVariable Integer idTransacao, @RequestBody @Valid PaymentDTO paymentDTO) {

        paymentDTO = paymentService.update(idTransacao,paymentDTO);

        return ResponseEntity.status(HttpStatus.OK).body("{ \"payment\" : \"/payment/"+paymentDTO.getIdTransacao()+ "\"}");
    }


    @DeleteMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> delete(@PathVariable Integer idTransacao) {
        return new ResponseEntity<>(paymentService.delete(idTransacao),HttpStatus.OK);
    }

 }
