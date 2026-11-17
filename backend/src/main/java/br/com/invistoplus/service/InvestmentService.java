package br.com.invistoplus.service;

import br.com.invistoplus.domain.Investment;
import br.com.invistoplus.domain.InvestmentEntity;
import br.com.invistoplus.domain.InvestmentType;
import br.com.invistoplus.domain.Stock;
import br.com.invistoplus.domain.InvestmentFund;
import br.com.invistoplus.domain.PublicBond;
import br.com.invistoplus.exception.InvestmentNotFoundException;
import br.com.invistoplus.repository.InvestmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service layer que contém a lógica de negócio do sistema.
 */
@Service
@Transactional
public class InvestmentService {
    
    private final InvestmentRepository repository;
    
    public InvestmentService(InvestmentRepository repository) {
        this.repository = repository;
    }
    
    /**
     * Cria um novo investimento do tipo Ação.
     */
    public InvestmentEntity createStock(String name, BigDecimal buyPrice, 
                                        BigDecimal currentPrice, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        InvestmentEntity entity = new InvestmentEntity(name, InvestmentType.ACAO);
        entity.setBuyPrice(buyPrice);
        entity.setCurrentPrice(currentPrice);
        entity.setQuantity(quantity);
        return repository.save(entity);
    }
    
    /**
     * Cria um novo Fundo de Investimento.
     */
    public InvestmentEntity createFund(String name, BigDecimal quotaBuyValue,
                                        BigDecimal quotaCurrentValue, int quotas,
                                        BigDecimal adminFeePercent) {
        if (quotas <= 0) {
            throw new IllegalArgumentException("Quantidade de cotas deve ser maior que zero");
        }
        InvestmentEntity entity = new InvestmentEntity(name, InvestmentType.FUNDO);
        entity.setQuotaBuyValue(quotaBuyValue);
        entity.setQuotaCurrentValue(quotaCurrentValue);
        entity.setQuantity(quotas);
        entity.setAdminFeePercent(adminFeePercent);
        return repository.save(entity);
    }
    
    /**
     * Cria um novo Título Público.
     */
    public InvestmentEntity createPublicBond(String name, BigDecimal faceValue,
                                              BigDecimal interestRate, int yearsToMaturity,
                                              boolean preFixed) {
        if (yearsToMaturity <= 0) {
            throw new IllegalArgumentException("Prazo deve ser maior que zero");
        }
        InvestmentEntity entity = new InvestmentEntity(name, InvestmentType.TITULO_PUBLICO);
        entity.setFaceValue(faceValue);
        entity.setInterestRate(interestRate);
        entity.setYearsToMaturity(yearsToMaturity);
        entity.setPreFixed(preFixed);
        return repository.save(entity);
    }
    
    /**
     * Busca um investimento pelo ID.
     */
    @Transactional(readOnly = true)
    public Investment getById(UUID id) {
        InvestmentEntity entity = repository.findById(id)
            .orElseThrow(() -> new InvestmentNotFoundException(id));
        
        return mapToInvestment(entity);
    }
    
    /**
     * Lista todos os investimentos.
     */
    @Transactional(readOnly = true)
    public List<InvestmentEntity> findAll() {
        return repository.findAll();
    }
    
    /**
     * Calcula o rendimento total da carteira.
     */
    @Transactional(readOnly = true)
    public BigDecimal getTotalYield() {
        return repository.findAll().stream()
                .map(InvestmentEntity::calculateYield)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    /**
     * Remove um investimento da carteira.
     */
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new InvestmentNotFoundException(id);
        }
        repository.deleteById(id);
    }
    
    private Investment mapToInvestment(InvestmentEntity entity) {
        if (entity.getInvestmentType() == InvestmentType.ACAO) {
            return new Stock(
                entity.getName(),
                entity.getBuyPrice(),
                entity.getQuantity(),
                entity.getCurrentPrice()
            );
        } else if (entity.getInvestmentType() == InvestmentType.FUNDO) {
            return new InvestmentFund(
                entity.getName(),
                entity.getBuyPrice(),
                entity.getQuantity(),
                entity.getQuotaCurrentValue(),
                entity.getAdminFeePercent()
            );
        } else {
            return new PublicBond(
                entity.getName(),
                entity.getFaceValue(),
                entity.getInterestRate(),
                entity.getYearsToMaturity(),
                entity.getPreFixed()
            );
        }
    }
}