package com.example.demo.service;

import com.example.demo.entity.RebalancingAlertRecord;

import java.util.List;
import java.util.Optional;

public interface RebalancingAlertService {

    RebalancingAlertRecord createAlert(RebalancingAlertRecord alert);

    RebalancingAlertRecord resolveAlert(Long alertId);

    List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId);

    Optional<RebalancingAlertRecord> getAlertById(Long id);
}
