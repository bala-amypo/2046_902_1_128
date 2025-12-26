package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {
    
    private final RebalancingAlertRecordRepository alertRecordRepository;
    
    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository alertRecordRepository) {
        this.alertRecordRepository = alertRecordRepository;
    }
    
    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {
        return alertRecordRepository.save(alert);
    }
    
    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {
        RebalancingAlertRecord alert = alertRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with id: " + id));
        alert.setResolved(true);
        return alertRecordRepository.save(alert);
    }
    
    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return alertRecordRepository.findByInvestorId(investorId);
    }
    
    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return alertRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with id: " + id));
    }
    
    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertRecordRepository.findAll();
    }
}