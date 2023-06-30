# Introdução ao Jakarta NoSQL

Projeto exemplo utilizado na aula de Introdução ao Jakarta NoSQL

## Objetivos da aula

- Introdução sobre NoSQL e seus trade-offs;
- Conhecer o que é a especificação Jakarta EE, RI e o benefício de uso;
- Conhecer e configurar o Jakarta NoSQL e sua RI em projetos Java SE, Java EE e MicroProfile;
- Utilizar a API do Jakarta NoSQL para persistir, editar, consultar e excluir dados com um banco de dados NoSQL
- Mapear entidades com a API Jakarta NoSQL;
- Utilizar a API do Jakarta Data para criar consultas utilizando suas features (Query by Method);

Link da apresentação: https://docs.google.com/presentation/d/1GS9ycVFQRdm9nwHKdTji4Kj0LU4kX_s6SjGFWelVNKA/edit?usp=sharing


### O que é NoSQL?

NoSQL, que pode ser interpretado como “Not only SQL - Não apenas SQL", é um termo genérico que descreve uma categoria de sistemas de gerenciamento de banco de dados que diferem dos sistemas tradicionais de banco de dados relacional (RDBMS) em algumas maneiras significativas.

Existem diferentes tipos de bancos de dados NoSQL, no qual podemos referenciar a sua específica família, e cada uma é otimizada para diferentes tipos de estruturas de dados:

- **KeyValue - Chave-valor**: São banco de dados que armazenam dados como um conjunto de pares de chave-valor. Exemplos incluem Redis e DynamoDB.
- **Document - Documentos**: São bancos de dados que armazenam dados em formato de documentos, normalmente formatados como JSON. Exemplos incluem MongoDB, CouchDB ou Elasticsearch;
- **Column - Colunar:** São banco de dados que organizam os dados por colunas em vez de linhas, o que pode permitir consultas muito rápidas em grandes volumes de dados. Exemplos incluem Cassandra e HBase.
- **Graph - Grafos**: Eles armazenam dados como nós e arestas de um gráfico, o que é útil para dados interconectados. Exemplos incluem Neo4j e JanusGraph.

### Quais são os os trade-offs em utilizar NoSQL?

Trabalhar com bancos de dados NoSQL pode oferecer uma série de benefícios, especialmente quando você está lidando com grandes volumes de dados e precisa de alta velocidade para leitura e gravação de dados. Aqui estão alguns dos benefícios mais comuns:

- **Escalabilidade**: Os bancos de dados NoSQL são projetados para serem facilmente escalonados em vários servidores. Isso significa que você pode adicionar mais servidores ao seu cluster de banco de dados para lidar com cargas de trabalho maiores à medida que sua aplicação cresce.
- **Desempenho**: Os bancos de dados NoSQL geralmente oferecem tempos de resposta muito rápidos para consultas, especialmente quando você está lendo ou escrevendo grandes volumes de dados.
- **Flexibilidade de Modelo de Dados**: Diferentemente dos bancos de dados SQL, que exigem que você defina um esquema rígido para seus dados, os bancos de dados NoSQL geralmente permitem um esquema flexível. Isso significa que você pode armazenar diferentes tipos de dados em diferentes formas, o que pode ser muito útil se os seus dados não se encaixam bem em um modelo tabular.
- **Manuseio de dados não estruturados e semi-estruturados**: Bancos de dados NoSQL são excelentes para trabalhar com dados que não são estruturados ou semi-estruturados, como JSON, XML e outros formatos de dados.
- **Alta Disponibilidade:** Muitos bancos de dados NoSQL oferecem alta disponibilidade e tolerância a falhas, o que significa que eles podem continuar funcionando mesmo quando um ou mais servidores falham.


Por outro lado, vale ressaltar que bancos de dados NoSQL não são uma solução para todos os problemas. Para aplicações que requerem transações ACID complexas, por exemplo, um banco de dados SQL pode ser mais apropriado. A decisão de usar SQL ou NoSQL deve sempre ser baseada nas necessidades específicas do projeto. Assim como os benefícios, existem também algumas dificuldades e problemas comuns que os desenvolvedores podem enfrentar ao trabalhar com tecnologias NoSQL:

- **Modelagem de Dados**: A modelagem de dados em bancos de dados NoSQL pode ser muito diferente da modelagem relacional com a qual muitos desenvolvedores estão familiarizados. Isso pode levar a erros e ineficiências se os desenvolvedores não entenderem como modelar dados efetivamente para o tipo específico de banco de dados NoSQL que estão usando.
- **Falta de Padronização:** Existem muitos tipos de bancos de dados NoSQL e cada um pode ter suas próprias peculiaridades e formas de interação. Isso pode tornar mais difícil para os desenvolvedores mudar de um banco de dados NoSQL para outro, ou trabalhar com vários tipos de bancos de dados NoSQL em um único projeto.
- **Consistência:** Muitos bancos de dados NoSQL optam por relaxar as garantias de consistência em favor do desempenho e da disponibilidade (de acordo com o teorema CAP). Isso pode levar a situações em que os dados lidos de um banco de dados podem não refletir as gravações mais recentes.
- **Transações:** Bancos de dados NoSQL **normalmente** não suportam transações ACID completas (Atomicidade, Consistência, Isolamento, Durabilidade) como os bancos de dados relacionais. Isso pode ser um problema em aplicativos que exigem operações atômicas em vários itens de dados.
- **Ferramentas de Consulta e Análise:** Enquanto SQL é uma linguagem de consulta universalmente aceita com muitas ferramentas e recursos poderosos de análise de dados, as linguagens de consulta para bancos de dados NoSQL normalmente não seguem uma linguagem padrão, e ela pode variar de vendor pra vendor.
- **Segurança**: Embora muitos bancos de dados NoSQL tenham recursos de segurança, eles podem não ser tão maduros ou tão completos quanto aqueles encontrados nos bancos de dados relacionais (SQL). Além disso, a segurança pode ser mais difícil de gerenciar devido à falta de padrões entre diferentes bancos de dados NoSQL.

Por estas razões, é importante que os desenvolvedores entendam bem as características do tipo específico de banco de dados NoSQL que estão usando e considerem cuidadosamente os trade-offs ao decidir usar NoSQL para um determinado projeto.

Fontes:

- https://pt.wikipedia.org/wiki/NoSQL
- Introduction to NoSQL • Martin Fowler • GOTO 2012 https://www.youtube.com/watch?v=qI_g07C_Q5I
- Livro: Martin Fowler & Pramod Sadalage • NoSQL Distilled • https://amzn.to/3ChIpu7

### O que é Jakarta EE?

Jakarta EE, anteriormente conhecido como Java EE (Enterprise Edition), é um conjunto de especificações para o desenvolvimento de aplicativos corporativos cloud native em Java. Em 2017 a Oracle decidiu transferir o Java EE para a Eclipse Foundation, uma organização sem fins lucrativos que administra uma grande quantidade de projetos open-source.

O Jakarta EE provê aos desenvolvedores um compreensivo conjunto de especificações abertas neutras de vendedores que são usadas para desenvolver aplicações modernas e cloud native.

Para saber mais: https://jakarta.ee/

#### O que é uma especificação Jakarta EE?

Uma especificação Jakarta EE é um documento formal que define como uma determinada tecnologia ou API deve funcionar dentro do ecossistema Jakarta EE. Em outras palavras, é um conjunto de regras e diretrizes que as implementações devem seguir para serem consideradas compatíveis com a especificação.



#### O que é uma RI (Reference Implementation)?

No contexto do Jakarta EE, uma Implementação de Referência (Reference Implementation ou RI) é uma implementação de uma especificação que serve como um guia para outros desenvolvedores e fornece um exemplo concreto de como a especificação deve ser implementada.



#### Qual é o benefício em utilizar especificações Jakarta EE?

- Jakarta EE é um conjunto de especificação neutro em relação à vendors, isso significa a possibilidade de mudar o vendor nem a necessidade de mudar a implementação
- É um conjunto padrão bem conhecido e amplamente utilizado pois tem o foco em ser estável, portável e manter a compatibilidade com versões anteriores;
- Ser um padrão não significar ser algo rígido. O Jakarta EE é modular, então, dado o contexto da apliação que está sendo desenvolvida, é possivel escolher entre o Jakarta EE Plataform ou outros profiles, como o Web ou o Core;O Jakarta EE está sempre em busca da inovação no desenvolvimento cloud native com Java, permitindo que colaboradores ao redor do munto construam e moldem continuamente o futuro open-source do Jakarta EE como uma comunidade.

Para saber mais: https://jakarta.ee/about/why-jakarta-ee/

### O que é Jakarta NoSQL?

Jakarta NoSQL é uma estrutura Java que agiliza a integração de aplicativos Java com bancos de dados NoSQL.

Ela tem como objetivo fornecer as seguintes features para o desenvolvedor java:

- API padronizada para trabalhar com vários banco de dados NoSQL e assim aumentar a produtividade realizando operações NoSQL comuns;
- Modelo rico de mapeamento de objetos com anotações JPA-like;
- Uma API fluente Java para realizar consultas nas bases de dados NoSQL;
- APIs para os tipos de banco de dados de **chave-valor**, **documento** e **colunar**;

Para saber mais:

- https://github.com/jakartaee/nosql
- https://jakarta.ee/specifications/nosql



### O que é Eclipse JNoSQL?

É uma implementação referência - RI - das especificações Jakarta NoSQL e Jakarta Data oferecendo uma estrutura que simplifica a integração de aplicativos Java com bancos de dados NoSQL.

A implementação prove as seguintes features:

- Facilitar e aumentar a produtividade em nas operações com banco de dados NoSQL
- Rich Object Mapping integrado com CDI;
- Consulta baseada em uma API Fluent-API em Java;
- Emissão de eventos de ciclo de vida de persistência;
- Mapeamento de baixo nível usando APIs NoSQL padrão;
- API de modelo específico para cada categoria NoSQL;
- Modelo rico de mapeamento de objetos com anotações JPA-like;
- Pontos de extensão para explorar o comportamento particular de um banco de dados NoSQL;
- Utilização da API de grafos oferecido pelo Apache TinkerPop;
- Implementação da especificação Jakarta Data oferecendo o pattern repository para operações NoSQL;

Para saber mais: https://github.com/eclipse/jnosql;

### Bonus: o que é o Jakarta Data?

A especificação Jakarta Data fornece uma API para facilitar o acesso aos dados. Um desenvolvedor Java pode dividir a persistência do modelo com vários recursos, como a capacidade de compor métodos de consulta personalizados em uma interface Repository onde o framework irá implementá-lo. Muito similar ao Spring Data;

Para saber mais:

- https://jakarta.ee/specifications/data/
- https://github.com/jakartaee/data
