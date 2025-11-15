# Exercício: Padrão Adapter - Gerenciador de Mídia Social

Este projeto implementa um sistema de gerenciamento de mídias sociais utilizando o Padrão de Design Estrutural **Adapter**.

## 1. Objetivo

O objetivo é criar um sistema unificado (Cliente) capaz de interagir com diversas APIs de mídias sociais (Twitter, LinkedIn, Instagram, TikTok) que possuem interfaces e métodos de operação completamente diferentes (Adaptees). O padrão Adapter faz a "tradução" entre a nossa interface unificada e as APIs externas.

## 2. O Padrão Adapter

O Adapter atua como um intermediário, permitindo que classes com interfaces incompatíveis colaborem.

* **Cliente (Client):** O `GerenciadorMidiaSocial`. Ele só conhece a interface unificada.
* **Alvo (Target):** A interface `ISocialMediaAdapter`, que define os métodos unificados (`autenticar`, `postar`).
* **Adaptador (Adapter):** As classes `TwitterAdapter`, `LinkedInAdapter`, etc. Elas *implementam* o Target e *contêm* o Adaptee.
* **Adaptee (Adaptee):** As APIs externas (`TwitterAPI`, `LinkedInAPI`, etc.), com seus métodos específicos e incompatíveis.



## 3. Estrutura de Pastas

O projeto está organizado em pacotes que separam as responsabilidades: