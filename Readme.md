#  MusicStream - Motor de Assinaturas e Antifraude

Este projeto é a avaliação final (AT) da disciplina de Arquitetura de Software e Engenharia Escalável do curso de Engenharia de Software do Instituto Infnet. Trata-se do *Core Domain* de uma plataforma de streaming de música, focado na orquestração de assinaturas e bloqueio de transações fraudulentas.

##  Objetivo do Projeto
Demonstrar a aplicação prática de padrões arquiteturais avançados para lidar com lógicas de negócio complexas e mutáveis, garantindo que o sistema seja robusto e facilmente extensível.

##  Decisões Arquiteturais e Padrões

* **Domain-Driven Design (DDD):** O sistema foi modelado com foco no domínio. Adotamos o uso de *Aggregates* (ex: `Conta` atuando como Aggregate Root) e *Value Objects* (`CartaoDeCredito`), fugindo do anti-padrão de modelo anêmico.
* **Design Pattern (Strategy):** O motor antifraude foi construído utilizando o padrão comportamental *Strategy*. Cada regra de violação (Cartão Inativo, Alta Frequência, Duplicidade) é uma classe isolada que implementa a interface `RegraFraude`.
* **S.O.L.I.D. (Open/Closed Principle):** O motor de autorização de transações está fechado para modificações, mas aberto para extensão. Novas regras de fraude podem ser criadas adicionando novas classes sem alterar o serviço principal.
* **Linguagem Ubíqua:** Toda a modelagem foi escrita em português claro, alinhando o código com os especialistas de negócio (ex: `assinarPlano()`).

##  Stack Tecnológica
* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Banco de Dados H2 (In-Memory)**
* **Lombok**

##  Estrutura de Diretórios (Clean Architecture)
- `domain/`: Regras de negócio puras (Modelos, Value Objects e Domain Services).
- `application/`: Casos de uso e orquestração do sistema.
- `infrastructure/`: Comunicação externa, Repositórios JPA e carga inicial de dados (`DataLoader`).
- `presentation/`: Endpoints e Controladores REST.

---

##  Como Executar a Aplicação

1. Clone o repositório:
   ```bash
   git clone (https://github.com/SEU_USUARIO/musicstream.git)
