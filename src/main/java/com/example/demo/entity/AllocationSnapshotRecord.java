package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;
    private Double totalPortfolioValue;
    private LocalDateTime snapshotDate;

    @Column(columnDefinition = "TEXT")
    private String allocationJson;

    public AllocationSnapshotRecord() {}

    public AllocationSnapshotRecord(Long investorId, Double totalPortfolioValue, LocalDateTime snapshotDate, String allocationJson) {
        this.investorId = investorId;
        this.totalPortfolioValue = totalPortfolioValue;
        this.snapshotDate = snapshotDate;
        this.allocationJson = allocationJson;
    }

    public Long getId() { return id; }
    public Long getInvestorId() { return investorId; }
    public void setInvestorId(Long investorId) { this.investorId = investorId; }

    public Double getTotalPortfolioValue() { return totalPortfolioValue; }
    public void setTotalPortfolioValue(Double totalPortfolioValue) { this.totalPortfolioValue = totalPortfolioValue; }

    public LocalDateTime getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }

    public String getAllocationJson() { return allocationJson; }
    public void setAllocationJson(String allocationJson) { this.allocationJson = allocationJson; }
}
