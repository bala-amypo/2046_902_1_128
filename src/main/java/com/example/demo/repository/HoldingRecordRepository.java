package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRecordRepository extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestorId(Long investorId);

    // Test expects: findByValueGreaterThan(double)
    @Query("SELECT h FROM HoldingRecord h WHERE h.currentValue > :value")
    List<HoldingRecord> findByValueGreaterThan(@Param("value") double value);

    // Test expects: findByInvestorAndAssetClass(long, AssetClassType)
    @Query("SELECT h FROM HoldingRecord h WHERE h.investorId = :investor AND h.assetClass = :assetClass")
    List<HoldingRecord> findByInvestorAndAssetClass(
            @Param("investor") long investor,
            @Param("assetClass") AssetClassType assetClass
    );
}
