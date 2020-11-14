# Conversor de Moeda

_Projeto criado para a conversão de valor através das moedas repassadas pelo usuário, onde será feito o calculo de conversão de acordo com a taxa de conversão e retornado o valor calculado._

## Tecnologias

- Kotlin
- Spring Boot
- H2 DataBase
- Intellij
- Maven

## Propósito

Esse projeto tem como objetivo fazer a conversão de valores entre duas moedas distintas, conforme a taxa de conversão.

Foi desenvolvida uma API REST onde está preparada para receber uma JSON de solicitação com os dados para conversão e como resposta também retorna um JSON.

## Camadas

Para que o projeto mantenha a organização de responsabilidades, o mesmo está separado em camadas, onde fica mais de manutenção está dividida da seguinte forma:

- Controllers - controle de Requisições e Resposta
- Entities - models
- Repositories - comunicação com a base de dados
- Service - regras de negocio

    Outras camadas:

    - Exceptions - exceções de erros
    - Http - mantem a comunicação com o api de conversão
    - Docs - configuração do swagger

## Documentação

Para uma melhor visualização no que diz respeito a documentação, foi configurado e usado:

- SWAGGER

    link: http://localhost:port/swagger-ui/index.html

## Passo a passo

Como rodar a aplicação

1. Faça o clone do projeto no GitHub no repositorio:

    [https://github.com/GersonMorais/avaliacaojaya](https://github.com/GersonMorais/avaliacaojaya) 

2. Sugestão de IDE : Intellij com Maven
3. Insomnia/Postman 

    Ao rodar(Run) a aplicação pelo Intellij, abra o insomnia ou postman e faça as requisições.

4. Requisições

    Existem três requisições:

    - POST - [http://localhost:8080/transactions](http://localhost:8080/transactions)
        - Para criação da transação a ser gravada e calculada.
        - Corpo(Body) que espera receber(JSON):

            {
                  "userId": Int,
                  "originCurrency": String, 
                  "originValue": Double,
                  "targetCurrency": String
            }

    - GET - [http://localhost:8080/transactions/](http://localhost:8080/transactions/1)userId
        - userId = Usuario usado para criação da transação;
        - Retorna todas as transações criadas para o userId repassado;
    - GET - [http://localhost:8080/transactions](http://localhost:8080/transactions)
        - Retorna a lista de transações criadas.
5. Os dados podem ser consultados no H2 Data Base configurados com suas credenciais em currencyconverter/src/main/resources/application.properties e acessado atraves da url: [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp)
