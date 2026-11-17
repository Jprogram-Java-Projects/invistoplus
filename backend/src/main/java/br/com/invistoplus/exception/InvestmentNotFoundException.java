package br.com.invistoplus.exception;

import java.util.UUID;

/**
 * Exceção lançada quando um investimento não é encontrado no banco.
 */
public class InvestmentNotFoundException extends RuntimeException {
    
    public InvestmentNotFoundException(UUID id) {
        super("Investimento com ID " + id + " não encontrado");
    }
    
    public InvestmentNotFoundException(String message) {
        super(message);
    }
}