package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl {

    private final RebalancingAlertRecordRepository repository;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository repository) {
        this.repository = repository;
    }

    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {

        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException(
                    "Alert can only be created when currentPercentage > targetPercentage"
            );
        }

        return repository.save(alert);
    }

    public RebalancingAlertRecord resolveAlert(Long id) {

        RebalancingAlertRecord alert =
                repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Alert not found: " + id));

        alert.setResolved(true);

        return repository.save(alert);
    }

    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }
}
