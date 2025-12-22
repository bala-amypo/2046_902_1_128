package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.entity.enums.AssetClassType;
import java.time.LocalDateTime;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    private Double currentValue;

    private LocalDateTime snapshotDate = LocalDateTime.now();

    public HoldingRecord() {}

    public HoldingRecord(Long investorId, AssetClassType assetClass, Double currentValue) {
        if (currentValue <= 0) {
            throw new IllegalArgumentException("currentValue must be > 0");
        }
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentValue = currentValue;
        this.snapshotDate = LocalDateTime.now();
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
            throw new IllegalArgumentException("currentValue must be > 0");
        }
        this.currentValue = currentValue;
    }

    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }
}
