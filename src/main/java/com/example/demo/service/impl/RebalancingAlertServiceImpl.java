package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository repository;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {

        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException(
                    "Alert can only be created when currentPercentage > targetPercentage"
            );
        }

        return repository.save(alert);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long alertId) {

        RebalancingAlertRecord alert = repository.findById(alertId)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found: " + alertId));

        alert.setResolved(true);

        return repository.save(alert);
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public Optional<RebalancingAlertRecord> getAlertById(Long id) {
        return repository.findById(id);
    }


    @Override
    public void deleteAlert(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Alert not found: " + id);
        }
        repository.deleteById(id);
    }
}
