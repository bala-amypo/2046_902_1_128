package com.example.demo.service;

import com.example.demo.entity.RebalancingAlertRecord;
import java.util.List;

public interface RebalancingAlertService {

    RebalancingAlertRecord createAlert(RebalancingAlertRecord record);

    RebalancingAlertRecord resolveAlert(Long id);

    RebalancingAlertRecord getAlertById(Long id);

    List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId);

    List<RebalancingAlertRecord> getAllAlerts();
}
