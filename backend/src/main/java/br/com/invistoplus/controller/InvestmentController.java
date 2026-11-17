package br.com.invistoplus.controller;

import br.com.invistoplus.domain.Investment;
import br.com.invistoplus.domain.InvestmentEntity;
import br.com.invistoplus.service.InvestmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * REST Controller para gerenciamento de investimentos.
 * Expondo endpoints para interação com a frontend.
 */
@RestController
@RequestMapping("/api/v1/investments")
@CrossOrigin(origins = "*") // Para desenvolvimento - ajustar em produção
public class InvestmentController {
    
    private final InvestmentService investmentService;
    
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }
    
    @Operation(summary = "Criar nova ação")
    @PostMapping("/stocks")
    public ResponseEntity<InvestmentEntity> createStock(
            @RequestParam String name,
            @RequestParam BigDecimal buyPrice,
            @RequestParam BigDecimal currentPrice,
            @RequestParam int quantity) {
        InvestmentEntity stock = investmentService.createStock(name, buyPrice, currentPrice, quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(stock);
    }
    
    @Operation(summary = "Criar novo fundo de investimento")
    @PostMapping("/funds")
    public ResponseEntity<InvestmentEntity> createFund(
            @RequestParam String name,
            @RequestParam BigDecimal quotaBuyValue,
            @RequestParam BigDecimal quotaCurrentValue,
            @RequestParam int quotas,
            @RequestParam BigDecimal adminFeePercent) {
        InvestmentEntity fund = investmentService.createFund(name, quotaBuyValue, quotaCurrentValue, quotas, adminFeePercent);
        return ResponseEntity.status(HttpStatus.CREATED).body(fund);
    }
    
    @Operation(summary = "Criar novo título público")
    @PostMapping("/bonds")
    public ResponseEntity<InvestmentEntity> createPublicBond(
            @RequestParam String name,
            @RequestParam BigDecimal faceValue,
            @RequestParam BigDecimal interestRate,
            @RequestParam int yearsToMaturity,
            @RequestParam boolean preFixed) {
        InvestmentEntity bond = investmentService.createPublicBond(name, faceValue, interestRate, yearsToMaturity, preFixed);
        return ResponseEntity.status(HttpStatus.CREATED).body(bond);
    }
    
    @Operation(summary = "Listar todos os investimentos")
    @GetMapping
    public ResponseEntity<List<InvestmentEntity>> getAllInvestments() {
        List<InvestmentEntity> investments = investmentService.findAll();
        return ResponseEntity.ok(investments);
    }
    
    @Operation(summary = "Buscar investimento por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable UUID id) {
        Investment investment = investmentService.getById(id);
        return ResponseEntity.ok(investment);
    }
    
    @Operation(summary = "Calcular rendimento total da carteira")
    @GetMapping("/total-yield")
    public ResponseEntity<BigDecimal> getTotalYield() {
        BigDecimal total = investmentService.getTotalYield();
        return ResponseEntity.ok(total);
    }
    
    @Operation(summary = "Remover investimento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable UUID id) {
        investmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}