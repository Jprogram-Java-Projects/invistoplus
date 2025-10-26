package br.com.invistoplus;

public class PublicBond extends TypesInvestments<PublicBond> {
    private final double faceValue;
    private final double interestRate;
    private final int yearsToMaturity;
    private final boolean preFixed;

    private PublicBond(String name, double faceValue, double interestRate, int yearsToMaturity, boolean preFixed) {
        super(name);
        this.faceValue = faceValue;
        this.interestRate = interestRate;
        this.yearsToMaturity = yearsToMaturity;
        this.preFixed = preFixed;
    }

    public static PublicBond of(String name, double faceValue, double interestRate, int yearsToMaturity, boolean preFixed) {
        if (faceValue <= 0 || interestRate <= 0 || yearsToMaturity <= 0)
            throw new IllegalArgumentException("Valores inválidos para título público");
        return new PublicBond(name, faceValue, interestRate, yearsToMaturity, preFixed);
    }

    @Override
    public double calculateYield() {
        double total = faceValue * Math.pow(1 + (interestRate / 100), yearsToMaturity);
        return preFixed ? total - faceValue : (total * 0.98) - faceValue; // simplificado
    }
}
