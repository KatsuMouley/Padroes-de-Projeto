package com.banco.moderno;

/**
 * Um DTO (Data Transfer Object) simples para a resposta do sistema moderno.
 */
public record RespostaAutorizacao(boolean sucesso, String codigoAutorizacao) {
}