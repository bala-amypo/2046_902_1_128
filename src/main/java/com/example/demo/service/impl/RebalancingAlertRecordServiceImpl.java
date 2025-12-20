package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertRecordServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository repo;

    public RebalancingAlertRecordServiceImpl(RebalancingAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord record) {
        return repo.save(record);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {
        RebalancingAlertRecord record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));

        record.setResolved(true);
        return repo.save(record);
    }

    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
