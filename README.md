# Sistema de Gerenciamento de Manutenções

API REST desenvolvida em Java com Spring Boot para gerenciamento de usuários,
empresas, equipamentos e manutenções.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- Bean Validation

## Arquitetura

A aplicação utiliza uma arquitetura monolítica organizada em camadas:

Controller → Service → Repository → PostgreSQL

## Executando o projeto

### Pré-requisitos

- Java 17
- Maven
- PostgreSQL

### Banco de dados

Criar o banco:

```sql
CREATE DATABASE manutencao_db;