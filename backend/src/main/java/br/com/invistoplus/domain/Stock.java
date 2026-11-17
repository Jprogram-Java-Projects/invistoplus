package br.com.invistoplus.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Representa uma ação (ação de empresa - renda variável).
 * Utiliza record para imutabilidade (Java 21 feature).
 */
public record Stock(
        String name,
        BigDecimal buyPrice,
        BigDecimal currentPrice,
        int quantity,
        InvestmentType investmentType
) implements Investment {

    public Stock(String name, BigDecimal buyPrice, int quantity, BigDecimal currentPrice) {
        this(name, buyPrice, currentPrice, quantity, InvestmentType.ACAO);
        
        if (buyPrice == null || currentPrice == null || quantity <= 0) {
            throw new IllegalArgumentException("Preço e quantidade são obrigatórios e quantidade > 0");
        }
        if (buyPrice.compareTo(BigDecimal.ZERO) <= 0 || currentPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preços devem ser positivos");
        }
    }

    @Override
    public BigDecimal calculateYield(BigDecimal valorAtual, int quantidade) {
        // Rendimento = (Preço Atual - Preço Compra) * Quantidade
        return valorAtual.subtract(buyPrice)
                .multiply(BigDecimal.valueOf(quantidade))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InvestmentType getInvestmentType() {
        return investmentType;
    }

    /**
     * Cálculo do rendimento com os valores armazenados no objeto
     */
    public BigDecimal calculateYield() {
        return calculateYield(currentPrice, quantity);
    }
}