package br.infnet.musicstream.domain.model;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // No JPA, Value Objects são "Embutidos" na tabela principal
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDeCredito {
    private String numero;
    private boolean ativo;
}