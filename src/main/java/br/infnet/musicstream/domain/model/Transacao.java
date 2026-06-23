package br.infnet.musicstream.domain.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long contaId;
    private Double valor;
    private String comerciante;
    private LocalDateTime dataHora;

    public Transacao(Long contaId, Double valor, String comerciante) {
        this.contaId = contaId;
        this.valor = valor;
        this.comerciante = comerciante;
        this.dataHora = LocalDateTime.now();
    }
}