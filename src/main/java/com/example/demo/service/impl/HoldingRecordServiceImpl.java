package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repository;

    public HoldingRecordServiceImpl(HoldingRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord record) {

        if (record.getCurrentValue() <= 0) {
            throw new IllegalArgumentException("Current value must be > 0");
        }

        return repository.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return repository.findAll();
    }

    // ⭐ NEW — required by controller
    @Override
    public void deleteHolding(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Holding not found: " + id);
        }
        repository.deleteById(id);
    }
}
