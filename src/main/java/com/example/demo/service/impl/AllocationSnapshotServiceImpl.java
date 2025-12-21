package com.example.demo.service.impl;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRepository;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRepository repo;

    public AllocationSnapshotServiceImpl(AllocationSnapshotRepository repo) {
        this.repo = repo;
    }

    @Override
    public AllocationSnapshotRecord createSnapshot(Long investorId, Double value, String json) {
        AllocationSnapshotRecord snapshot = new AllocationSnapshotRecord(
                investorId,
                value,
                LocalDateTime.now(),
                json
        );
        return repo.save(snapshot);
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return repo.findAll();
    }
}
