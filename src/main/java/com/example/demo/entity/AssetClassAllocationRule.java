package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;

@Entity
@Table(name = "asset_class_allocation_rules")
public class AssetClassAllocationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long investorId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetClassType assetClass;
    
    @Column(nullable = false)
    private Double targetPercentage;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    public AssetClassAllocationRule() {}
    
    public AssetClassAllocationRule(Long investorId, AssetClassType assetClass, Double targetPercentage, Boolean active) {
        if (targetPercentage < 0 || targetPercentage > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.targetPercentage = targetPercentage;
        this.active = active;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    
    public AssetClassType getAssetClass() { return assetClass; }
    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }
    
    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) { 
        if (targetPercentage < 0 || targetPercentage > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }
        this.targetPercentage = targetPercentage; 
    }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}