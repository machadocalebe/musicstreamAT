package br.infnet.musicstream.infrastructure;

import br.infnet.musicstream.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // O Spring Data JPA converte esse nome de método em um "SELECT * WHERE conta_id = ? AND data_hora > ?"
    List<Transacao> findByContaIdAndDataHoraAfter(Long contaId, LocalDateTime dataHora);
}