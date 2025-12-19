package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private LocalDateTime snapshotDate = LocalDateTime.now();

    private Double totalPortfolioValue;

    @Column(columnDefinition = "TEXT")
    private String allocationJson;

    public AllocationSnapshotRecord() {}

    public AllocationSnapshotRecord(Long investorId, Double totalPortfolioValue, String allocationJson) {
        if (totalPortfolioValue <= 0) {
            throw new IllegalArgumentException("totalPortfolioValue must be > 0");
        }
        this.investorId = investorId;
        this.totalPortfolioValue = totalPortfolioValue;
        this.allocationJson = allocationJson;
        this.snapshotDate = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }

    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }

    public Double getTotalPortfolioValue() { return totalPortfolioValue; }
    public void setTotalPortfolioValue(Double totalPortfolioValue) {
        if (totalPortfolioValue <= 0) {
            throw new IllegalArgumentException("totalPortfolioValue must be > 0");
        }
        this.totalPortfolioValue = totalPortfolioValue;
    }

    public String getAllocationJson() { return allocationJson; }
    public void setAllocationJson(String allocationJson) { this.allocationJson = allocationJson; }
}
