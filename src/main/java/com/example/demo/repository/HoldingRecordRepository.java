package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestorId(Long investorId);

    // REQUIRED BY TESTS
    List<HoldingRecord> findByValueGreaterThan(Double value);

    // REQUIRED BY TESTS
    List<HoldingRecord> findByInvestorAndAssetClass(Long investorId, AssetClassType assetClass);

    // (Optional) you can still keep your earlier methods if you want:
    List<HoldingRecord> findByCurrentValueGreaterThan(Double value);

    List<HoldingRecord> findByInvestorIdAndAssetClass(Long investorId, AssetClassType assetClass);
}
