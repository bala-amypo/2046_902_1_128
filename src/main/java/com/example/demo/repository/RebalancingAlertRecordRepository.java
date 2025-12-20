package com.example.demo.repository;

import com.example.demo.entity.RebalancingAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RebalancingAlertRecordRepository extends JpaRepository<RebalancingAlertRecord, Long> {

    List<RebalancingAlertRecord> findByInvestorId(Long investorId);

    List<RebalancingAlertRecord> findByResolvedFalse();
}
