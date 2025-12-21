package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repo;

    public HoldingRecordServiceImpl(HoldingRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public HoldingRecord create(HoldingRecord record) {
        return repo.save(record);
    }

    @Override
    public HoldingRecord update(Long id, HoldingRecord updated) {
        HoldingRecord record = getById(id);
        record.setAssetClass(updated.getAssetClass());
        record.setCurrentValue(updated.getCurrentValue());
        record.setSnapshotDate(updated.getSnapshotDate());
        return repo.save(record);
    }

    @Override
    public HoldingRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Holding record not found"));
    }

    @Override
    public List<HoldingRecord> getByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    @Override
    public List<HoldingRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
