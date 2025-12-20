package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertRecordServiceImpl implements RebalancingAlertRecordService {

    private final RebalancingAlertRecordRepository repo;

    public RebalancingAlertRecordServiceImpl(RebalancingAlertRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public RebalancingAlertRecord save(RebalancingAlertRecord record) {
        return repo.save(record);
    }

    @Override
    public List<RebalancingAlertRecord> getAll() {
        return repo.findAll();
    }
}