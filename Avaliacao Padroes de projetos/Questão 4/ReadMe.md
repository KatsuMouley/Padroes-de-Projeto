💎 Questão 4: Validação de Documentos Fiscais
Este diretório contém a solução para a Questão 4, que implementa uma cadeia de validação para Notas Fiscais Eletrônicas (NF-e).

Padrão de Projeto Identificado: Chain of Responsibility
O problema exige que um documento passe por múltiplos validadores em cadeia. A cadeia possui regras complexas, como execução condicional ("se X falhar, pule Y"), circuit breaker (parar após 3 falhas) e rollback.

🏛️ Justificativa da Decisão de Design
O padrão Chain of Responsibility foi escolhido por desacoplar o remetente de uma solicitação (o documento) dos seus receptores (os validadores). O padrão permite que a solicitação flua por uma cadeia de objetos de processamento.

Desacoplamento e Extensibilidade: O cliente que inicia a validação só precisa conhecer o primeiro elo da cadeia. Os validadores individuais não se conhecem; eles apenas sabem como processar sua parte e passar a solicitação para o next (próximo) da cadeia. Isso torna trivial adicionar, remover ou reordenar validadores (Princípio Open/Closed).

Responsabilidade Única (SOLID): Cada classe de validador (ValidadorSchemaXML, ValidadorBancoDados) tem uma única e clara responsabilidade, tornando o código limpo e fácil de manter.

Gerenciamento de Lógica Complexa (Decisão de Implementação):

Para evitar duplicação de código, foi criada uma classe ValidadadoBase (um Abstract Handler). Esta classe gerencia a lógica comum de circuit breaking, timeout e a chamada ao próximo elo (passarParaProximo).

Objeto de Contexto: O DocumentoFiscal não é apenas um DTO; ele atua como um Context Object que é passado pela cadeia. Ele carrega não apenas os dados (xmlContent), mas também o estado da validação (a List<String> erros, a flag validacaoCriticaFalhou e o Map estadoRollback), permitindo que a cadeia execute as lógicas complexas de rollback e execução condicional.

Rollback: A lógica de rollback foi implementada no ValidadorBase verificando se o número de erros aumentou após a chamada dos elos subsequentes. Se sim, ele invoca um método rollback() (implementado concretamente pelo ValidadorBancoDados).

🚀 Estrutura da Solução
Validador (Interface Handler): Define o contrato da cadeia (ex: setNext(), validar()).

ValidadorBase (Abstract Handler): Classe abstrata que gerencia a lógica da cadeia (circuit breaker, rollback, etc.).

ValidadorSchemaXML, ValidadorSefaz, etc. (Concrete Handlers): As implementações de validação específicas.

DocumentoFiscal (Context Object): O objeto que é passado ao longo da cadeia, carregando dados e estado.