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

import br.com.fiap.payment.model.ExceptionResponse;
import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(value = "Payment", description = "Payment Service REST API")
@RequestMapping(value = "/payment", produces = "application/json")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @ApiOperation(httpMethod = "GET", value = "Método get para buscar um pagamento filtrand por id.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna um PaymentDTO", response = PaymentDTO.class),
    		@ApiResponse(code = 404, message = "Id não encontrado", response = ExceptionResponse.class)
    })
    @GetMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> findById(@ApiParam(value = "Payment Id", required = true)  @PathVariable(value="idTransacao", required = true) Integer idTransacao){

        System.out.printf("findById %s", idTransacao);

        PaymentDTO paymentDTO = paymentService.findById(idTransacao);

        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    
    @ApiOperation(httpMethod = "POST", value = "Método post para salvar um pagamento.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna uma com uma mensagem  /payment/?",  response = PaymentDTO.class),
    		@ApiResponse(code = 404, message = "Numero do cartão não encontrado, erro para cadastrar.",  response = ExceptionResponse.class)
    })
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid PaymentDTO paymentDTO){

        paymentDTO = paymentService.save(paymentDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("{ \"payment\" : \"/payment/"+paymentDTO.getIdTransacao()+ "\"}");
    }

    
    @ApiOperation(httpMethod = "PUT", value = "Método put para atualizar um pagamento filtrand por id.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna uma com uma mensagem  /payment/?",  response = PaymentDTO.class),
    		@ApiResponse(code = 400, message = "Erro para atualizar.",  response = ExceptionResponse.class)
    })
    @PutMapping("/{idTransacao}")
    public ResponseEntity update(@ApiParam(value = "Payment Id", required = true) @PathVariable Integer idTransacao, @RequestBody @Valid PaymentDTO paymentDTO) {

        paymentDTO = paymentService.update(idTransacao,paymentDTO);

        return ResponseEntity.status(HttpStatus.OK).body("{ \"payment\" : \"/payment/"+paymentDTO.getIdTransacao()+ "\"}");
    }

    @ApiOperation(httpMethod = "DELETE", value = "Método delete que deleta um pagamento filtrand por id.")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Retorna um PaymentDTO",  response = PaymentDTO.class)
    })
    @DeleteMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> delete(@ApiParam(value = "Payment Id", required = true) @PathVariable Integer idTransacao) {
        return new ResponseEntity<>(paymentService.delete(idTransacao),HttpStatus.OK);
    }

 }
