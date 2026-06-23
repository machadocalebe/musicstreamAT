package br.infnet.musicstream.domain.service;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorizadorTransacaoDomainService {

    // O Spring injeta automaticamente TODAS as classes que implementam a interface (SOLID: Open/Closed)
    private final List<RegraFraude> regras;

    public AutorizadorTransacaoDomainService(List<RegraFraude> regras) {
        this.regras = regras;
    }

    public void autorizar(Transacao transacao, List<Transacao> historicoUltimosDoisMinutos, Conta conta) {
        for (RegraFraude regra : regras) {
            regra.validar(transacao, historicoUltimosDoisMinutos, conta);
        }
    }
}