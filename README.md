# route-api
## Como executar o projeto.

Escolhi o framework do Spring Boot para criar a estrutura REST da aplicação, então basta ter o java instalado na maquina 
e executar o arquivo RouteApiApplication.java

## Estrutura de Arquivos/Pacotes

Escolhi o básico do clean architecture para estruturar o projeto, separação em camadas, divididas pela core, que podemos pensar como a regra de negócio, 
as excessões que gostaria de estar respondendo na minha API e o framework, que podemos pensar como recursos externos que podem ser alterados conforme a necessidade.

## Explique as decisões de design adotadas para a solução

Sempre busquei respeitar os principios de código limpo, adicionar um pouco de SOLID e deixar uma arquitetura limpa, tentando deixar ao maximo um código legivel 
e de certa certa forma simples de se entender, para isso busquei a orientação a objeto pois ao meu entender é mais facil entender um código que representa algo 
do mundo real. 

## Descreva sua APÌ Rest de forma simplificada.

Essa aplicação utiliza um arquivo CSV como persistencia, disponibiliza duas funções ao usuario final, a primeira permite que ele veja o caminho mais barato 
entre dois aeroportos, independente de quantas conexões ele terá de realizar para chegar até seu destino. E na segunda a aplicação da a liberdade ao usuário 
cadastrar novos aeroportos e conexões como ele desejar. Tudo isso disponibilizado em uma API REST.  
