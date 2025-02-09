# Itaú Unibanco - Desafio de Programação

![Cover Photo](docs/assets/imgs/cover-photo.jpg)

[![licence mit](https://img.shields.io/badge/licence-MIT-blue.svg)](./LICENSE)
[![Openapi](https://img.shields.io/badge/openapi-3.1-green?logo=openapi)](https://swagger.io/specification/)

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

## Descrição do Desafio

> Sua missão, caso você aceite, é criar uma API REST que recebe Transações e retorna Estatísticas sob essas transações. Para este desafio, a API deve ser criada utilizando-se de Java ou [Kotlin](https://kotlinlang.org/) e Spring Boot.

[Descrição Completa do Desafio](README_DESAFIO.md)

## Como Executar o Projeto

### Requisitos para Executar o Projeto

- Git: [Link to Download](https://git-scm.com/)
- Docker: [Link to Download](https://docs.docker.com/get-docker/)

### Rodando o Projeto

1. Escolha um diretório para clonar o projeto
    - Selecione um diretório em seu sistema operaional onde deseja baixar os arquivos do projeto (ex: `~/projects`).

2. Clone o projeto:
    - Rode o seguinte comando no seu terminal:

```bash
git clone https://github.com/Maykon-JDS/desafio-itau-vaga-99-junior.git
```

3. Navegue até o diretório raiz do projeto
   - Acesse o diretório raiz do projeto pelo terminal:

```bash
cd desafio-itau-vaga-99-junior/
```

4. Construa os containers Docker
   - Use o Docker Compose para construir os containers do projeto:

```bash
docker compose -f ./docker/docker-compose.yml build
```

1. Inicie os containers Docker
   - Inicialize os containers para executar o projeto:

```bash
docker compose -f ./docker/docker-compose.yml up -d
```

6. Abra seu navegador e navegue até a URL da documentação da API do projeto:
   - Acesse o projeto no navegador: [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)