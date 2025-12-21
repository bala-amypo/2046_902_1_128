package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshot_record")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Column(columnDefinition = "TEXT")
    private String allocationJson;

    private Float totalPortfolioValue;

    private LocalDateTime snapshotDate;

    public AllocationSnapshotRecord() {
        this.snapshotDate = LocalDateTime.now();
    }

    public AllocationSnapshotRecord(Long investorId, String allocationJson, Float totalPortfolioValue) {
        this.investorId = investorId;
        this.allocationJson = allocationJson;
        this.totalPortfolioValue = totalPortfolioValue;
        this.snapshotDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getAllocationJson() {
        return allocationJson;
    }

    public void setAllocationJson(String allocationJson) {
        this.allocationJson = allocationJson;
    }

    public Float getTotalPortfolioValue() {
        return totalPortfolioValue;
    }

    public void setTotalPortfolioValue(Float totalPortfolioValue) {
        this.totalPortfolioValue = totalPortfolioValue;
    }

    public LocalDateTime getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDateTime snapshotDate) {
        this.snapshotDate = snapshotDate;
    }
}
