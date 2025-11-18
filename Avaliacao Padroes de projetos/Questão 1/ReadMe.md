💎 Questão 1: Sistema de Análise de Risco
Este diretório contém a solução para a Questão 1, que implementa um sistema de análise de risco financeiro.

Padrão de Projeto Identificado: Strategy
A questão descreve um sistema que precisa executar diferentes algoritmos (Value at Risk, Expected Shortfall, Stress Testing) para a mesma tarefa (cálculo de risco). Os requisitos principais são:

Os algoritmos devem ser "intercambiáveis em tempo de execução".

Eles devem compartilhar um "contexto complexo" (parâmetros financeiros).

O cliente (o sistema principal) não deve conhecer os detalhes de implementação dos algoritmos.

🏛️ Justificativa da Decisão de Design
O padrão Strategy foi escolhido por ser a solução ideal para encapsular uma família de algoritmos e torná-los independentes do cliente que os utiliza.

Princípio SOLID (Open/Closed): O padrão Strategy permite que o sistema esteja "aberto para extensão" (podemos adicionar novos algoritmos de risco, como MonteCarloStrategy, sem esforço) e "fechado para modificação" (não precisamos alterar o ProcessadorRisco ou as estratégias existentes).

Intercambialidade: A classe ProcessadorRisco (o Contexto do padrão) mantém uma referência à interface AlgoritmoRiscoStrategy (a Strategy). O método setAlgoritmo() permite que o cliente troque a implementação concreta em tempo de execução, satisfazendo o requisito principal.

Desacoplamento: O ProcessadorRisco não sabe como o VaR é calculado, ele apenas sabe que deve chamar o método calcular(). Toda a lógica de negócios é delegada para a estratégia concreta.

Contexto Complexo: O requisito de "compartilhar um contexto" é resolvido pela criação de um DTO (Data Transfer Object), o ContextoRisco. Este objeto é passado como parâmetro para o método calcular(), dando a cada estratégia todos os dados necessários para operar sem precisar manter um estado interno.

🚀 Estrutura da Solução
AlgoritmoRiscoStrategy (Interface Strategy): Define o contrato único (calcular(ContextoRisco)) que todas as estratégias devem seguir.

ValueAtRiskStrategy, ExpectedShortfallStrategy, StressTestingStrategy (Concrete Strategies): Implementações concretas que contêm os algoritmos (dummy) de cálculo.

ProcessadorRisco (Context): A classe cliente que utiliza o padrão. Ela mantém uma instância da estratégia atual e delega a execução para ela.

ContextoRisco (DTO): Um record Java que armazena os dados financeiros complexos.