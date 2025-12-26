package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertRecordController {
    
    private final RebalancingAlertService rebalancingAlertService;
    
    public RebalancingAlertController(RebalancingAlertService rebalancingAlertService) {
        this.rebalancingAlertService = rebalancingAlertService;
    }
    
    @PostMapping
    public ResponseEntity<RebalancingAlertRecord> createAlert(@RequestBody RebalancingAlertRecord alert) {
        return ResponseEntity.ok(rebalancingAlertService.createAlert(alert));
    }
    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<RebalancingAlertRecord> resolveAlert(@PathVariable Long id) {
        return ResponseEntity.ok(rebalancingAlertService.resolveAlert(id));
    }
    
    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<RebalancingAlertRecord>> getAlertsByInvestor(@PathVariable Long investorId) {
        return ResponseEntity.ok(rebalancingAlertService.getAlertsByInvestor(investorId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RebalancingAlertRecord> getAlertById(@PathVariable Long id) {
        return ResponseEntity.ok(rebalancingAlertService.getAlertById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<RebalancingAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(rebalancingAlertService.getAllAlerts());
    }
}