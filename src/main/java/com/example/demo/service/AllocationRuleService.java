package com.example.demo.service;

import com.example.demo.entity.AssetClassAllocationRule;
import java.util.List;

public interface AllocationRuleService {

    AssetClassAllocationRule createRule(AssetClassAllocationRule rule);

    List<AssetClassAllocationRule> getRulesByInvestor(Long investorId);

    List<AssetClassAllocationRule> getAllRules();
}
