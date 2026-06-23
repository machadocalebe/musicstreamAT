package br.infnet.musicstream.domain.service;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RegraCartaoAtivo implements RegraFraude {
    @Override
    public void validar(Transacao nova, List<Transacao> historico, Conta conta) {
        if (!conta.getCartaoDeCredito().isAtivo()) {
            throw new RuntimeException("Transação negada: Cartão não ativo.");
        }
    }
}