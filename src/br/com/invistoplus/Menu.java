package br.com.invistoplus;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Portfolio<Investment> portfolio = new Portfolio<>();
    
    private final TypesInvestments<Stock> stockCatalog = new TypesInvestments<>("Ações") {
        @Override 
        public double calculateYield() { return totalYield(); }
    };

    private final TypesInvestments<InvestmentFund> fundCatalog = new TypesInvestments<>("Fundos") {
        @Override 
        public double calculateYield() { return totalYield(); }
    };

    private final TypesInvestments<PublicBond> bondCatalog = new TypesInvestments<>("Títulos Públicos") {
        @Override 
        public double calculateYield() { return totalYield(); }
    };
    
    private void init() {
        stockCatalog.addInvestment(Stock.of("PETR4", 25.0, 100, 28.0));
        stockCatalog.addInvestment(Stock.of("VALE3", 60.0, 50, 65.0));
    	
        fundCatalog.addInvestment(InvestmentFund.of("XP Macro", 10.0, 100, 11.5, 1.0));
        
        bondCatalog.addInvestment(PublicBond.of("Tesouro Selic", 1000.0, 10.0, 3, true));
        bondCatalog.addInvestment(PublicBond.of("Tesouro IPCA", 1500.0, 12.0, 5, false));
    }
    

    public void start() {
    		init();
    		
    		int option;
        do {
            showMenu();
            option = readInt();
            switch (option) {
                case 1 -> makeInvestment();
                case 2 -> listPortfolio();
                case 3 -> showTotalYield();
                case 4 -> sellFlow();
                case 0 -> System.out.println("Encerrando o programa!");
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);
    }

    private void showMenu() {
    		System.out.println("\n======= Invisto+ =======\n");
        System.out.println("1- Fazer Investimento");
        System.out.println("2- Listar carteira");
        System.out.println("3- Rendimento total");
        System.out.println("4- Vender investimentos");
        System.out.println("0- Sair\n");
        System.out.print("Escolha: ");
    }
    
    private void makeInvestment() {
    		int option;
        do {
        		showMenuInvestment();
            option = readInt();
            switch (option) {
                case 1 -> buyStockFlow();
                case 2 -> buyFundFlow();
                case 3 -> buyBondFlow();
                case 0 -> System.out.println("--> Saindo do Menu de investimento");
                default -> System.out.println("Opção inválida");
            }
        } while (option != 0);
    }
    
    
    private void showMenuInvestment() {
    		System.out.println("\n========= FAZER INVESTIMENTO ========\n");
        System.out.println("1- Comprar Ação");
        System.out.println("2- Comprar Fundo");
        System.out.println("3- Comprar Título Público");
        System.out.println("0- Sair\n");
        System.out.print("Escolha: ");
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Número inválido. Digite novamente: ");
        }
        int v = scanner.nextInt();
        scanner.nextLine();
        return v;
    }

//    private double readDouble(String prompt) {
//        System.out.print(prompt);
//        while (!scanner.hasNextDouble()) {
//            scanner.next();
//            System.out.print("Valor inválido. Digite novamente: ");
//        }
//        double v = scanner.nextDouble();
//        scanner.nextLine();
//        return v;
//    }
    
    private <T extends Investment> void buyFromCatalog(TypesInvestments<T> catalog, String title) {
        System.out.println("\n=== " + title + " DISPONÍVEIS ===");
        
        for (int i = 0; i < catalog.investments.size(); i++) {
            T item = catalog.investments.get(i);
            System.out.printf("%d - %s (Rendimento: %.2f)%n",
                    i + 1, item.getName(), item.calculateYield());
        }

        System.out.print("\nEscolha o número: ");
        int choice = readInt() - 1;

        if (choice < 0 || choice >= catalog.investments.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        T chosen = catalog.investments.get(choice);
        portfolio.buy(chosen);
    }

    private void buyStockFlow() {
        buyFromCatalog(stockCatalog, "AÇÕES");
    }

    private void buyFundFlow() {
        buyFromCatalog(fundCatalog, "FUNDOS");
    }

    private void buyBondFlow() {
        buyFromCatalog(bondCatalog, "TÍTULOS PÚBLICOS");
    }

    

//    private void buyStockFlow() {
//        System.out.print("Nome: ");
//        String name = scanner.nextLine();
//        double buyPrice = readDouble("Preço de compra: ");
//        int qty = (int) readDouble("Quantidade: ");
//        double current = readDouble("Cotação atual: ");
//        Stock s = Stock.of(name, buyPrice, qty, current);
//        portfolio.buy(s);
//    }

//    private void buyFundFlow() {
//        System.out.print("Nome: ");
//        String name = scanner.nextLine();
//        double buyQuota = readDouble("Valor cota compra: ");
//        int quotas = (int) readDouble("Quantidade cotas: ");
//        double currentQuota = readDouble("Valor cota atual: ");
//        double admin = readDouble("Taxa admin anual (%): ");
//        InvestmentFund f = InvestmentFund.of(name, buyQuota, quotas, currentQuota, admin);
//        portfolio.buy(f);
//    }

//    private void buyBondFlow() {
//        System.out.print("Nome: ");
//        String name = scanner.nextLine();
//        double face = readDouble("Valor de face: ");
//        double rate = readDouble("Taxa anual (%): ");
//        int years = (int) readDouble("Prazo anos: ");
//        System.out.print("Pré-fixado? (s/n): ");
//        boolean pre = scanner.nextLine().trim().equalsIgnoreCase("s");
//        PublicBond b = PublicBond.of(name, face, rate, years, pre);
//        portfolio.buy(b);
//    }

    private void listPortfolio() {
    		var isEmpty = portfolio.getInvestments().isEmpty();
    	
        System.out.println("\n--> Carteira:");
        
        if(isEmpty) {
        		System.out.println("Nenhum investimento em sua carteira!");
        }else {
        		portfolio.listInvestments();
        }
    }

    private void showTotalYield() {
        System.out.printf("Rendimento total: %.2f%n", portfolio.totalYield());
    }

    private void sellFlow() {
        var investments = portfolio.getInvestments();

        if (investments.isEmpty()) {
            System.out.println("\nNenhum investimento na carteira para vender.");
            return;
        }

        System.out.println("\n======== VENDER INVESTIMENTO ========\n");
        for (int i = 0; i < investments.size(); i++) {
            Investment inv = investments.get(i);
            System.out.printf("%d - %s (Rendimento: %.2f)%n",
                    i + 1, inv.getName(), inv.calculateYield());
        }

        System.out.print("\nEscolha o número para vender: ");
        int choice = readInt() - 1;

        if (choice < 0 || choice >= investments.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Investment sold = investments.get(choice);
        portfolio.sell(sold);
    }

}

