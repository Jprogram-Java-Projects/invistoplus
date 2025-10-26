package br.com.invistoplus;

public class Stock extends TypesInvestments<Stock> {
    private final double buyPrice;
    private final double currentPrice;
    private final int quantity;

    private Stock(String name, double buyPrice, int quantity, double currentPrice) {
        super(name);
        this.buyPrice = buyPrice;
        this.currentPrice = currentPrice;
        this.quantity = quantity;
    }

    public static Stock of(String name, double buyPrice, int quantity, double currentPrice) {
        if (buyPrice <= 0 || currentPrice <= 0 || quantity <= 0)
            throw new IllegalArgumentException("Valores inválidos para ação");
        return new Stock(name, buyPrice, quantity, currentPrice);
    }

    @Override
    public double calculateYield() {
        return (currentPrice - buyPrice) * quantity;
    }
}
