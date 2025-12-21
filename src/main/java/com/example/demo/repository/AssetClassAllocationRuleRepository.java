package com.example.demo.repository;

import com.example.demo.entity.AssetClassAllocationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AssetClassAllocationRuleRepository
        extends JpaRepository<AssetClassAllocationRule, Long> {

    List<AssetClassAllocationRule> findByInvestorId(Long investorId);

    @Query("SELECT r FROM AssetClassAllocationRule r WHERE r.investorId = ?1 AND r.active = true")
    List<AssetClassAllocationRule> findActiveRulesHql(Long investorId);
}
