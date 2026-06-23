package br.infnet.musicstream.infrastructure;

import br.infnet.musicstream.domain.model.CartaoDeCredito;
import br.infnet.musicstream.domain.model.Conta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ContaRepository contaRepository) {
        return args -> {
            // Criando uma conta de teste com cartão ativo
            CartaoDeCredito cartao = new CartaoDeCredito("1234-5678-9012-3456", true);
            Conta conta = new Conta("Calebe Correia Machado", cartao);

            contaRepository.save(conta);

            System.out.println("✅ Ambiente pronto! Conta de teste criada com ID: " + conta.getId());
        };
    }
}