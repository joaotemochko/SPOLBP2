# Estruturação de Aplicação Web - Projeto Base

Este projeto demonstra a separação em camadas em uma aplicação Spring Boot:

- **Model:** Representa as entidades do domínio (ex: Tarefa).
- **DTO (Data Transfer Object):** Controla o que entra e sai da API, escondendo atributos internos.
- **Service:** Contém toda a regra de negócio e lógica de manipulação de dados.
- **Controller:** Ponto de entrada das requisições HTTP. Não possui lógica de negócios, apenas delega tarefas.
