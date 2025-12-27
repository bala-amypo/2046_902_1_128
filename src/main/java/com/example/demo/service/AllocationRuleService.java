package com.example.demo.service;

import com.example.demo.entity.AssetClassAllocationRule;

import java.util.List;
import java.util.Optional;

public interface AllocationRuleService {

    AssetClassAllocationRule createRule(AssetClassAllocationRule rule);

    AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule);

    List<AssetClassAllocationRule> getRulesByInvestor(Long investorId);

    Optional<AssetClassAllocationRule> getRuleById(Long id);
}
