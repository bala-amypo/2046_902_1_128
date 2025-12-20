package com.example.demo.controller;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleService service;

    public AllocationRuleController(AllocationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AssetClassAllocationRule create(@RequestBody AssetClassAllocationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule update(
            @PathVariable Long id,
            @RequestBody AssetClassAllocationRule updatedRule) {

        return service.updateRule(id, updatedRule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> getByInvestor(@PathVariable Long investorId) {
        return service.getRulesByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AssetClassAllocationRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<AssetClassAllocationRule> getAll() {
        return service.getRulesByInvestor(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRule(id);
    }
}
