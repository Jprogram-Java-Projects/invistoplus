package br.com.invistoplus.domain;

import java.math.BigDecimal;

/**
 * Interface base para todos os tipos de investimentos.
 * Define o contrato para cálculo de rendimento e identificação.
 */
public interface Investment {
    
    /**
     * Calcula e retorna o rendimento líquido deste investimento em reais.
     * @param valorAtual Valor atual ou de mercado do investimento
     * @param quantidade Quantidade de unidades possuídas
     * @return Rendimento líquido em BigDecimal
     */
    BigDecimal calculateYield(BigDecimal valorAtual, int quantidade);
    
    /**
     * Retorna o nome/identificador único do investimento
     * @return nome do ativo
     */
    String getName();
    
    /**
     * Retorna o tipo do investimento (AÇÃO, FUNDO, TÍTULO)
     * @return InvestmentType
     */
    InvestmentType getInvestmentType();
}