package br.com.invistoplus;

public class InvestmentFund extends TypesInvestments<InvestmentFund> {
    private final double quotaValue;
    private final int quotas;
    private final double quotaCurrentValue;
    private final double adminFee;

    private InvestmentFund(String name, double quotaValue, int quotas, double quotaCurrentValue, double adminFee) {
        super(name);
        this.quotaValue = quotaValue;
        this.quotas = quotas;
        this.quotaCurrentValue = quotaCurrentValue;
        this.adminFee = adminFee;
    }

    public static InvestmentFund of(String name, double quotaValue, int quotas, double quotaCurrentValue, double adminFee) {
        if (quotaValue <= 0 || quotas <= 0 || quotaCurrentValue <= 0 || adminFee < 0)
            throw new IllegalArgumentException("Valores inválidos para fundo");
        return new InvestmentFund(name, quotaValue, quotas, quotaCurrentValue, adminFee);
    }

    @Override
    public double calculateYield() {
        double gross = (quotaCurrentValue - quotaValue) * quotas;
        double fee = gross * (adminFee / 100);
        return gross - fee;
    }
}
