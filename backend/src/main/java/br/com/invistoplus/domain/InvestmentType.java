package br.com.invistoplus.domain;

/**
 * Enum representando os tipos de investimentos suportados pelo sistema.
 */
public enum InvestmentType {
    ACAO("ação/equity - renda variável"),
    FUNDO("fundo de investimento - renda diversificada"),
    TITULO_PUBLICO("título público - renda fixa");

    private final String descricao;

    InvestmentType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}