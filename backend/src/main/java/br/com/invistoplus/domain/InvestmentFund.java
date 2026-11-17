package br.com.invistoplus.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Representa um Fundo de Investimento (cotas com taxa de administração).
 * Utiliza record para imutabilidade (Java 21 feature).
 */
public record InvestmentFund(
        String name,
        BigDecimal quotaBuyValue,
        BigDecimal quotaCurrentValue,
        int quotas,
        BigDecimal adminFeePercent,
        InvestmentType investmentType
) implements Investment {

    public InvestmentFund(String name, BigDecimal quotaBuyValue, int quotas,
                          BigDecimal quotaCurrentValue, BigDecimal adminFeePercent) {
        this(name, quotaBuyValue, quotaCurrentValue, quotas, adminFeePercent, InvestmentType.FUNDO);
        
        if (quotaBuyValue == null || quotaCurrentValue == null || quotas <= 0 || adminFeePercent == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios e quantidade/taxa >= 0");
        }
        if (quotaBuyValue.compareTo(BigDecimal.ZERO) <= 0 || quotaCurrentValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valores de cota devem ser positivos");
        }
        if (adminFeePercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Taxa de administração não pode ser negativa");
        }
    }

    @Override
    public BigDecimal calculateYield(BigDecimal valorAtual, int quantidade) {
        // Lucro bruto = (Cota Atual - Cota Compra) * Cotas
        BigDecimal gross = valorAtual.subtract(quotaBuyValue)
                .multiply(BigDecimal.valueOf(quantidade))
                .setScale(2, RoundingMode.HALF_EVEN);
        
        // Taxa de administração do lucro bruto
        BigDecimal fee = gross.multiply(adminFeePercent)
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_EVEN);
        
        return gross.subtract(fee);
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
        return calculateYield(quotaCurrentValue, quotas);
    }
}