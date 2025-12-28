package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AssetClassAllocationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {

        Double pct = rule.getTargetPercentage();

        if (pct < 0 || pct > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }

        return repository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(Long id, AssetClassAllocationRule updatedRule) {

        AssetClassAllocationRule existing =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Rule not found: " + id));

        Double pct = updatedRule.getTargetPercentage();

        if (pct < 0 || pct > 100) {
            throw new IllegalArgumentException("Target percentage must be between 0 and 100");
        }

        existing.setTargetPercentage(updatedRule.getTargetPercentage());
        existing.setActive(updatedRule.getActive());

        return repository.save(existing);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public Optional<AssetClassAllocationRule> getRuleById(Long id) {
        return repository.findById(id);
    }

    // ⭐ NEW — required by controller
    @Override
    public void deleteRule(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Rule not found: " + id);
        }
        repository.deleteById(id);
    }
}
