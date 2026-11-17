package br.com.invistoplus.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Entidade JPA que representa um investimento persistido no banco.
 * Usa SINGLE_TABLE inheritance strategy com um discriminator column.
 */
@Entity
@Table(name = "investments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "investment_type",
    discriminatorType = DiscriminatorType.STRING
)
public class InvestmentEntity {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "buy_price")
    private BigDecimal buyPrice;
    
    @Column(name = "current_price")
    private BigDecimal currentPrice;
    
    @Column(name = "quantity")
    private Integer quantity;
    
    @Column(name = "quota_buy_value")
    private BigDecimal quotaBuyValue;
    
    @Column(name = "quota_current_value")
    private BigDecimal quotaCurrentValue;
    
    @Column(name = "admin_fee_percent")
    private BigDecimal adminFeePercent;
    
    @Column(name = "face_value")
    private BigDecimal faceValue;
    
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    
    @Column(name = "years_to_maturity")
    private Integer yearsToMaturity;
    
    @Column(name = "pre_fixed")
    private Boolean preFixed;
    
    @Column(name = "investment_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private InvestmentType investmentType;
    
    protected InvestmentEntity() {}
    
    public InvestmentEntity(String name, InvestmentType type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.investmentType = type;
    }
    
    // Getters e Setters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public BigDecimal getBuyPrice() { return buyPrice; }
    public void setBuyPrice(BigDecimal buyPrice) { this.buyPrice = buyPrice; }
    
    public BigDecimal getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(BigDecimal currentPrice) { this.currentPrice = currentPrice; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public BigDecimal getQuotaBuyValue() { return quotaBuyValue; }
    public void setQuotaBuyValue(BigDecimal quotaBuyValue) { this.quotaBuyValue = quotaBuyValue; }
    
    public BigDecimal getQuotaCurrentValue() { return quotaCurrentValue; }
    public void setQuotaCurrentValue(BigDecimal quotaCurrentValue) { this.quotaCurrentValue = quotaCurrentValue; }
    
    public BigDecimal getAdminFeePercent() { return adminFeePercent; }
    public void setAdminFeePercent(BigDecimal adminFeePercent) { this.adminFeePercent = adminFeePercent; }
    
    public BigDecimal getFaceValue() { return faceValue; }
    public void setFaceValue(BigDecimal faceValue) { this.faceValue = faceValue; }
    
    public BigDecimal getInterestRate() { return interestRate; }
    public void setInterestRate(BigDecimal interestRate) { this.interestRate = interestRate; }
    
    public Integer getYearsToMaturity() { return yearsToMaturity; }
    public void setYearsToMaturity(Integer yearsToMaturity) { this.yearsToMaturity = yearsToMaturity; }
    
    public Boolean getPreFixed() { return preFixed; }
    public void setPreFixed(Boolean preFixed) { this.preFixed = preFixed; }
    
    public InvestmentType getInvestmentType() { return investmentType; }
    public void setInvestmentType(InvestmentType investmentType) { this.investmentType = investmentType; }
    
    public BigDecimal calculateYield() {
        if (investmentType == InvestmentType.ACAO) {
            return currentPrice.subtract(buyPrice)
                    .multiply(BigDecimal.valueOf(quantity))
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else if (investmentType == InvestmentType.FUNDO) {
            BigDecimal gross = quotaCurrentValue.subtract(quotaBuyValue)
                    .multiply(BigDecimal.valueOf(quantity))
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN);
            BigDecimal fee = gross.multiply(adminFeePercent)
                    .divide(BigDecimal.valueOf(100))
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN);
            return gross.subtract(fee);
        } else {
            BigDecimal factor = BigDecimal.ONE.add(interestRate.divide(BigDecimal.valueOf(100), 6, BigDecimal.ROUND_HALF_EVEN)).pow(yearsToMaturity);
            BigDecimal total = faceValue.multiply(factor).setScale(2, BigDecimal.ROUND_HALF_EVEN);
            return total.subtract(faceValue).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
    }
}