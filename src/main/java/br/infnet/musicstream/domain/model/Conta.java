package br.infnet.musicstream.domain.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private CartaoDeCredito cartaoDeCredito;

    private String planoAtivo; // Ex: "PREMIUM", "FREE"

    public Conta(String nome, CartaoDeCredito cartaoDeCredito) {
        this.nome = nome;
        this.cartaoDeCredito = cartaoDeCredito;
        this.planoAtivo = "FREE";
    }

    // Intention Revealing Interface (Ação clara do negócio)
    public void assinarPlano(String novoPlano) {
        if (!this.planoAtivo.equals("FREE")) {
            throw new IllegalStateException("O usuário já possui um plano ativo. Cancele o atual antes de trocar.");
        }
        if (!this.cartaoDeCredito.isAtivo()) {
            throw new IllegalArgumentException("Não é possível assinar com um cartão inativo.");
        }
        this.planoAtivo = novoPlano;
    }
}