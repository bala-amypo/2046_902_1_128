package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        return repo.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule rule) {
        AssetClassAllocationRule existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        existing.setTargetPercentage(rule.getTargetPercentage());
        existing.setInvestorId(rule.getInvestorId());
        existing.setAssetClass(rule.getAssetClass());
        existing.setActive(rule.getActive());


        return repo.save(existing);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public void deleteRule(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    @Override
    public List<AssetClassAllocationRule> getAllRules() {
        return repo.findAll();
    }
}
