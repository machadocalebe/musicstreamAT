package br.infnet.musicstream.presentation;

import br.infnet.musicstream.application.OperacoesApplicationService;
import br.infnet.musicstream.domain.model.Transacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operacoes")
public class OperacoesController {

    private final OperacoesApplicationService service;

    public OperacoesController(OperacoesApplicationService service) {
        this.service = service;
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> processarTransacao(
            @RequestParam Long contaId,
            @RequestParam Double valor,
            @RequestParam String comerciante) {

        try {
            // Repassa para a camada de aplicação orquestrar a regra de negócio
            Transacao transacao = service.processarTransacao(contaId, valor, comerciante);
            return ResponseEntity.ok(transacao);
        } catch (RuntimeException e) {
            // Se o motor antifraude barrar, cai aqui e devolve status 400 (Bad Request)
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}