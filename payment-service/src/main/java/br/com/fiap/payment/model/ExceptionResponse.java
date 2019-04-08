package br.com.fiap.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import lombok.*;

@Getter
public class ExceptionResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime tempoHora;
    private String messagem;
    private String detalhes;
    
    public ExceptionResponse(LocalDateTime tempoHora, String messagem, String detalhes) {
        super();
        this.tempoHora = tempoHora;
        this.messagem = messagem;
        this.detalhes = detalhes;
    }
    
    
}
