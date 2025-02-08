# Itaú Unibanco - Desafio de Programação

![Cover Photo](docs/assets/imgs/cover-photo.jpg)

[![licence mit](https://img.shields.io/badge/licence-MIT-blue.svg)](./LICENSE)
[![Openapi](https://img.shields.io/badge/openapi-3.1-green?logo=openapi)](https://swagger.io/specification/)
<!-- [![Conventional Commits](https://img.shields.io/badge/Conventional%20Commits-1.0.0-%23FE5196?logo=conventionalcommits&logoColor=white)](https://conventionalcommits.org) -->

## Sumário
- [Itaú Unibanco - Desafio de Programação](#itaú-unibanco---desafio-de-programação)
  - [Sumário](#sumário)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
  - [Descrição do Desafio](#descrição-do-desafio)
  - [Como Executar o Projeto](#como-executar-o-projeto)
    - [Requisitos para Executar o Projeto](#requisitos-para-executar-o-projeto)
    - [Rodando o Projeto](#rodando-o-projeto)

## Tecnologias Utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)&nbsp;
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)&nbsp;
![Openapi](https://img.shields.io/badge/-openapi-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)&nbsp;
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)&nbsp;
![Eclipse](https://img.shields.io/badge/Eclipse%20IDE-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)&nbsp;
![Docker](https://img.shields.io/badge/Docker-0895e7?style=for-the-badge&logo=Docker&logoColor=white)&nbsp;

<!-- ## Estrutura do Projeto
Para entender a estrutura do projeto, consulte [Estrutura do Projeto](link_para_o_documentacao_estrutura.md). -->

## Descrição do Desafio

> Sua missão, caso você aceite, é criar uma API REST que recebe Transações e retorna Estatísticas sob essas transações. Para este desafio, a API deve ser criada utilizando-se de Java ou [Kotlin](https://kotlinlang.org/) e Spring Boot.

[Descrição Completa do Desafio](README_DESAFIO.md)

## Como Executar o Projeto

### Requisitos para Executar o Projeto

- Git: [Link to Download](https://git-scm.com/)
- Docker: [Link to Download](https://docs.docker.com/get-docker/)

### Rodando o Projeto

1. Choose a directory to clone the project's repository
    - Select a directory on your system where you want to download the project files (e.g., `~/projects`).

2. Clone the project repository:
    - Run the following command in your terminal:

```bash
git clone https://github.com/Maykon-JDS/converter.git
```
3. Navigate to the project root directory
    - Access the project root directory with the terminal:

```bash
cd converter
```
4. Build the Docker containers
   - Use Docker Compose to build the project's environment:

```bash
docker compose -f ./docker/docker-compose.yml build
```
5. Start the Docker containers
   - Initialize the containers to run the project:

```bash
docker compose -f ./docker/docker-compose.yml up
```
6. Open your browser and navigate to the project URL
   - Access the project in your browser: `127.0.0.1:8001`