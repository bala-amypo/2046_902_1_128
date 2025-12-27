package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl {

    private final HoldingRecordRepository repository;

    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    public HoldingRecord recordHolding(HoldingRecord record) {

        if (record.getCurrentValue() <= 0) {
            throw new IllegalArgumentException("Current value must be > 0");
        }

        return repository.save(record);
    }

    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repository.findById(id);
    }
}
