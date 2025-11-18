💎 Questão 3: Controle de Usina Nuclear
Este diretório contém a solução para a Questão 3, que modela os estados operacionais complexos de uma usina nuclear.

Padrão de Projeto Identificado: State
O problema descreve um objeto (UsinaNuclear) cujo comportamento muda drasticamente dependendo de seu estado interno (DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, etc.). Além disso, existem regras complexas que governam as transições entre esses estados.

🏛️ Justificativa da Decisão de Design
Usar uma série de if/else ou switch dentro da classe UsinaNuclear para gerenciar os estados violaria o Princípio de Responsabilidade Única (SOLID) e criaria uma classe massiva e impossível de manter.

O padrão State foi escolhido para resolver isso, permitindo que um objeto altere seu comportamento quando seu estado interno muda.

Encapsulamento de Estado: Cada estado (ex: EstadoOperacaoNormal, EstadoAlertaAmarelo) é encapsulado em sua própria classe. Toda a lógica de negócios e regras de transição relevantes apenas para aquele estado residem dentro daquela classe.

Transições Limpas: As transições de estado são tratadas pelas próprias classes de estado. Por exemplo, é o EstadoAlertaAmarelo que contém a lógica (if (temp > 400)) para transicionar para o EstadoAlertaVermelho. Isso remove a lógica de transição da classe UsinaNuclear (o Contexto).

Princípio SOLID (Open/Closed): O sistema é fácil de estender. Para adicionar um novo estado (ex: EstadoManutencaoProgramada), basta criar uma nova classe EstadoUsina sem modificar nenhuma das classes de estado existentes.

Requisitos Complexos: O padrão lidou elegantemente com requisitos complexos:

"EMERGENCIA só após ALERTA_VERMELHO": Isso é garantido pois somente o EstadoAlertaVermelho possui a lógica para transicionar para EstadoEmergencia.

"Modo Manutenção": Foi implementado como um estado especial (EstadoManutencao) que "sobreescreve" o comportamento. Ele armazena uma referência ao estado anterior para poder retornar a ele, satisfazendo o requisito de forma elegante.

🚀 Estrutura da Solução
EstadoUsina (Interface State): Define o contrato comum para todos os estados (ex: verificarCondicoes(), desligar()).

EstadoDesligada, EstadoOperacaoNormal, ... (Concrete States): Implementações concretas, cada uma gerenciando seu próprio comportamento e transições.

UsinaNuclear (Classe Context): A classe principal. Ela mantém uma referência ao seu estadoAtual e delega todas as chamadas de ação para esse objeto de estado.