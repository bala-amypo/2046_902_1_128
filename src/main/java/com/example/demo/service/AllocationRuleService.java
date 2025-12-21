package com.example.demo.service;

import com.example.demo.entity.AssetClassAllocationRule;
import java.util.List;

public interface AllocationRuleService {

    AssetClassAllocationRule createRule(AssetClassAllocationRule rule);

    AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule rule);

    AssetClassAllocationRule getRuleById(Long id);

    void deleteRule(Long id);

    List<AssetClassAllocationRule> getRulesByInvestor(Long investorId);

    List<AssetClassAllocationRule> getAllRules();
}
