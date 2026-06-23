package br.infnet.musicstream.domain.service;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import java.util.List;

public interface RegraFraude {
    void validar(Transacao novaTransacao, List<Transacao> historicoRecente, Conta conta);
}