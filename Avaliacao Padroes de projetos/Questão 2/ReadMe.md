💎 Questão 2: Integração com Sistema Legado
Este diretório contém a solução para a Questão 2, que integra um sistema moderno de processamento de transações com um sistema bancário legado.

Padrão de Projeto Identificado: Adapter
O problema é um caso clássico de incompatibilidade de interfaces. Temos uma interface moderna e "limpa" (ProcessadorTransacoes) que nosso sistema cliente usa, e uma interface legada (SistemaBancarioLegado) que possui métodos e tipos de dados completamente diferentes (ex: HashMap<String, Object>).

🏛️ Justificativa da Decisão de Design
O padrão Adapter (ou Wrapper) foi escolhido porque sua finalidade é exatamente converter a interface de uma classe em outra interface que o cliente espera.

Tradução de Interfaces: O LegadoAdapter atua como um tradutor. Ele implementa a interface moderna (ProcessadorTransacoes) que o cliente entende, mas "envolve" (ou "adapta") uma instância do sistema legado.

Encapsulamento da Complexidade: Toda a lógica de "tradução" é encapsulada dentro do adapter:

Tradução de Dados: Converte os parâmetros modernos (String moeda) para o formato legado (int codigoMoeda = 3).

Tratamento de Assinatura: Converte os múltiplos parâmetros do método autorizar() em um único HashMap para o método processarTransacao().

Campos Obrigatórios: Adiciona campos que só o legado conhece (ex: codigoSegurancaLegado), atendendo à restrição.

Bidirecionalidade: O adapter também funciona na direção oposta, conforme solicitado. Ele recebe a resposta legada (HashMap) e a traduz de volta para o DTO moderno (RespostaAutorizacao), garantindo que o cliente permaneça totalmente desacoplado do legado.

Princípio SOLID (Single Responsibility): O adapter assume a responsabilidade única de tradução. O cliente moderno permanece focado em suas regras de negócio, e o sistema legado permanece intocado.

🚀 Estrutura da Solução
ProcessadorTransacoes (Interface Target): A interface moderna que o nosso sistema cliente utiliza.

SistemaBancarioLegado (Interface Adaptee): A interface legada incompatível.

LegadoAdapter (Classe Adapter): A classe central. Ela implements ProcessadorTransacoes e contains um SistemaBancarioLegado.

RespostaAutorizacao (DTO): Objeto de dados usado pela interface moderna.