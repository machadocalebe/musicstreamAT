package br.infnet.musicstream.domain.service;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RegraAltaFrequencia implements RegraFraude {
    @Override
    public void validar(Transacao nova, List<Transacao> historico, Conta conta) {
        if (historico.size() >= 3) {
            throw new RuntimeException("Transação negada: Alta frequência em pequeno intervalo.");
        }
    }
}