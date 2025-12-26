package com.example.demo.repository;

import com.example.demo.entity.AllocationSnapshotRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationSnapshotRecordRepository extends JpaRepository<AllocationSnapshotRecord, Long> {
}