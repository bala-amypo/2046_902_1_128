package com.example.demo.entity;

import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rebalancing_alert_records")
public class RebalancingAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long investorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetClassType assetClass;

    @Column(nullable = false)
    private Double currentPercentage;

    @Column(nullable = false)
    private Double targetPercentage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertSeverity severity;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime alertDate;

    @Column(nullable = false)
    private Boolean resolved = false;

    public RebalancingAlertRecord() {}

    public RebalancingAlertRecord(
            Long investorId,
            AssetClassType assetClass,
            Double currentPercentage,
            Double targetPercentage,
            AlertSeverity severity,
            String message,
            LocalDateTime alertDate,
            Boolean resolved
    ) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.currentPercentage = currentPercentage;
        this.targetPercentage = targetPercentage;
        this.severity = severity;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }

    public void setInvestorId(Long investorId) { this.investorId = investorId; }

    public AssetClassType getAssetClass() { return assetClass; }

    public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }

    public Double getCurrentPercentage() { return currentPercentage; }

    public void setCurrentPercentage(Double currentPercentage) {
        this.currentPercentage = currentPercentage;
    }

    public Double getTargetPercentage() { return targetPercentage; }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public AlertSeverity getSeverity() { return severity; }

    public void setSeverity(AlertSeverity severity) { this.severity = severity; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getAlertDate() { return alertDate; }

    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }

    public Boolean getResolved() { return resolved; }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
