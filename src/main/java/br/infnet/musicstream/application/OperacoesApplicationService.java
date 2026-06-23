package br.infnet.musicstream.application;
import br.infnet.musicstream.domain.model.Conta;
import br.infnet.musicstream.domain.model.Transacao;
import br.infnet.musicstream.domain.service.AutorizadorTransacaoDomainService;
import br.infnet.musicstream.infrastructure.ContaRepository;
import br.infnet.musicstream.infrastructure.TransacaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperacoesApplicationService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;
    private final AutorizadorTransacaoDomainService autorizador;

    public OperacoesApplicationService(ContaRepository contaRepo, TransacaoRepository transacaoRepo, AutorizadorTransacaoDomainService autorizador) {
        this.contaRepository = contaRepo;
        this.transacaoRepository = transacaoRepo;
        this.autorizador = autorizador;
    }

    public Transacao processarTransacao(Long contaId, Double valor, String comerciante) {
        Conta conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Transacao novaTransacao = new Transacao(contaId, valor, comerciante);

        // Busca histórico dos últimos 2 minutos
        LocalDateTime doisMinutosAtras = LocalDateTime.now().minusMinutes(2);
        List<Transacao> historico = transacaoRepository.findByContaIdAndDataHoraAfter(contaId, doisMinutosAtras);

        // Dispara o motor antifraude do domínio! Se der erro, ele lança a exceção e não salva.
        autorizador.autorizar(novaTransacao, historico, conta);

        return transacaoRepository.save(novaTransacao);
    }
}