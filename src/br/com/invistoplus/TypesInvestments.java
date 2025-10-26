package br.com.invistoplus;

import java.util.ArrayList;
import java.util.List;

public abstract class TypesInvestments<T extends Investment> implements Investment {

    protected final List<T> investments = new ArrayList<>();
    private final String name;

    protected TypesInvestments(String name) {
        this.name = name;
    }

    public String getName() { return name; }


    public void addInvestment(T investment) {
        investments.add(investment);
    }

    public void listInvestments() {
        for (T inv : investments) {
            System.out.printf("%s: rendimento %.2f%n", inv.getName(), inv.calculateYield());
        }
    }

    public double totalYield() {
        return investments.stream().mapToDouble(Investment::calculateYield).sum();
    }
}
