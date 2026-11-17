package br.com.invistoplus;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Investment> {

    private List<T> investments = new ArrayList<>();

    public void buy(T investment) {
        investments.add(investment);
        System.out.println("\n-->"+ investment.getName() + " comprada!");
    }

    public void sell(T investment) {
        investments.remove(investment);
        System.out.println("\n-->"+ investment.getName() + " vendida!");
    }

    public double totalYield() {
        return investments.stream()
                .mapToDouble(Investment::calculateYield)
                .sum();
    }

    public void listInvestments() {
        investments.forEach(i ->
            System.out.printf("%s -> rendimento: %.2f%n",
                i.getName(), i.calculateYield())
        );
    }

    public List<T> getInvestments() {
        return investments;
    }
}
