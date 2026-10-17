# Impulso Profissional - Backend

Backend do projeto **Impulso Profissional**, desenvolvido em Java com Spring Boot e integrado ao MySQL.

## Sobre o projeto

O Impulso Profissional é uma plataforma voltada para adultos com 18 anos ou mais, com foco em empregabilidade e capacitação profissional.

ODS trabalhadas:

- ODS 8 - Trabalho Decente e Crescimento Econômico
- ODS 10 - Redução das Desigualdades

## Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- MySQL
- Maven

## Arquitetura

Controller -> Service -> Repository -> Entity -> MySQL

## CRUDs

O sistema possui 3 CRUDs completos:

- Empresas
- Vagas
- Cursos

Cada CRUD permite criar, listar, atualizar e excluir registros.

## Regra de negócio

Uma empresa não pode ser excluída enquanto possuir vagas ou cursos vinculados.

## Banco de Dados

Banco utilizado: MySQL

Nome do banco:

impulso_profissional

Para criar:

CREATE DATABASE impulso_profissional;

As tabelas são criadas e atualizadas pelo Hibernate/JPA.

## Configuração

Variáveis utilizadas:

DB_USERNAME
DB_PASSWORD

Exemplo no PowerShell:

$env:DB_USERNAME="root"
$env:DB_PASSWORD="sua_senha"

## API

A aplicação Spring Boot roda normalmente em:

http://localhost:8080

Endpoints principais:

- /api/empresas
- /api/vagas
- /api/cursos

## Frontend

https://github.com/edilsomdecampos/impulso-profissional-frontend

## Projeto

Projeto Final - Programa Transforma Futuros - Recode
