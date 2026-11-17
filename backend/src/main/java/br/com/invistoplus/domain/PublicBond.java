package br.com.invistoplus.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Representa um Título Público (renda fixa).
 * Utiliza record para imutabilidade (Java 21 feature).
 */
public record PublicBond(
        String name,
        BigDecimal faceValue,
        BigDecimal interestRate,
        int yearsToMaturity,
        boolean preFixed,
        InvestmentType investmentType
) implements Investment {

    public PublicBond(String name, BigDecimal faceValue, BigDecimal interestRate,
                      int yearsToMaturity, boolean preFixed) {
        this(name, faceValue, interestRate, yearsToMaturity, preFixed, InvestmentType.TITULO_PUBLICO);
        
        if (faceValue == null || interestRate == null || yearsToMaturity <= 0) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios e prazo > 0");
        }
        if (faceValue.compareTo(BigDecimal.ZERO) <= 0 || interestRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor de face e taxa de juros devem ser positivos");
        }
    }

    @Override
    public BigDecimal calculateYield(BigDecimal valorAtual, int quantidade) {
        // Método genérico não aplicável a títulos públicos
        // Cada título tem sua própria lógica de cálculo
        return calculateYield();
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
     * Cálculo do rendimento via juros compostos.
     * Fórmula: Montante = ValorFace * (1 + i)^t
     * Rendimento = Montante - ValorFace
     */
    public BigDecimal calculateYield() {
        // Juros compostos: (1 + i)^t
        BigDecimal one = BigDecimal.ONE;
        BigDecimal rateDecimal = interestRate.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN);
        
        // (1 + i)^t
        BigDecimal factor = one.add(rateDecimal).pow(yearsToMaturity);
        
        BigDecimal total = faceValue.multiply(factor)
                .setScale(2, RoundingMode.HALF_EVEN);
        
        BigDecimal yield = total.subtract(faceValue)
                .setScale(2, RoundingMode.HALF_EVEN);
        
        return yield;
    }
}