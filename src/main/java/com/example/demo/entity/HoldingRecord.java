package com.example.demo.entity;

import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "holding_records")
public class HoldingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long investorId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetClassType assetClass;
    
    @Column(nullable = false)
    private Double currentValue;
    
    @Column(nullable = false)
    private LocalDateTime snapshotDate;
    
    public HoldingRecord() {}
    
    public HoldingRecord(Long investorId, AssetClassType assetClass, Double currentValue, LocalDateTime snapshotDate) {
        if (currentValue <= 0) {
            throw new IllegalArgumentException("Current value must be > 0");
        }
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.snapshotDate = snapshotDate;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }
    
    public AssetClassType getAssetClass() { return assetClass; }
    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }
    
    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { 
        if (currentValue <= 0) {
            throw new IllegalArgumentException("Current value must be > 0");
        }
        this.currentValue = currentValue; 
    }
    
    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }
}