package br.infnet.musicstream.domain.service;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RegraTransacaoDuplicada implements RegraFraude {
    @Override
    public void validar(Transacao nova, List<Transacao> historico, Conta conta) {
        long duplicadas = historico.stream()
                .filter(t -> t.getComerciante().equals(nova.getComerciante()) && t.getValor().equals(nova.getValor()))
                .count();

        if (duplicadas >= 2) {
            throw new RuntimeException("Transação negada: Transação duplicada.");
        }
    }
}