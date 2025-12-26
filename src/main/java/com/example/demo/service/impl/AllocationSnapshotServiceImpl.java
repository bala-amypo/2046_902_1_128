package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.entity.enums.AlertSeverity;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {
    
    private final AllocationSnapshotRecordRepository snapshotRecordRepository;
    private final HoldingRecordRepository holdingRecordRepository;
    private final AssetClassAllocationRuleRepository allocationRuleRepository;
    private final RebalancingAlertRecordRepository alertRecordRepository;
    
    public AllocationSnapshotServiceImpl(AllocationSnapshotRecordRepository snapshotRecordRepository,
                                       HoldingRecordRepository holdingRecordRepository,
                                       AssetClassAllocationRuleRepository allocationRuleRepository,
                                       RebalancingAlertRecordRepository alertRecordRepository) {
        this.snapshotRecordRepository = snapshotRecordRepository;
        this.holdingRecordRepository = holdingRecordRepository;
        this.allocationRuleRepository = allocationRuleRepository;
        this.alertRecordRepository = alertRecordRepository;
    }
    
    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {
        List<HoldingRecord> holdings = holdingRecordRepository.findByInvestorId(investorId);
        if (holdings.isEmpty()) {
            throw new IllegalArgumentException("No holdings found for investor: " + investorId);
        }
        
        double totalValue = holdings.stream().mapToDouble(HoldingRecord::getCurrentValue).sum();
        if (totalValue <= 0) {
            throw new IllegalArgumentException("Total portfolio value must be > 0");
        }
        
        Map<AssetClassType, Double> allocations = new HashMap<>();
        for (HoldingRecord holding : holdings) {
            allocations.merge(holding.getAssetClass(), 
                            holding.getCurrentValue() / totalValue * 100, Double::sum);
        }
        
        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId, LocalDateTime.now(), totalValue, allocations.toString());
        snapshot = snapshotRecordRepository.save(snapshot);
        
        List<AssetClassAllocationRule> rules = allocationRuleRepository.findByInvestorIdAndActiveTrue(investorId);
        for (AssetClassAllocationRule rule : rules) {
            Double currentPercentage = allocations.get(rule.getAssetClass());
            if (currentPercentage != null && currentPercentage > rule.getTargetPercentage()) {
                RebalancingAlertRecord alert = new RebalancingAlertRecord(
                        investorId, rule.getAssetClass(), currentPercentage, rule.getTargetPercentage(),
                        AlertSeverity.MEDIUM, "Rebalancing needed", LocalDateTime.now(), false);
                alertRecordRepository.save(alert);
            }
        }
        
        return snapshot;
    }
    
    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snapshot not found with id: " + id));
    }
    
    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRecordRepository.findAll().stream()
                .filter(s -> s.getInvestorId().equals(investorId))
                .toList();
    }
    
    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRecordRepository.findAll();
    }
}