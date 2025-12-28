package com.example.demo.controller;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService allocationRuleService;

    public AllocationRuleController(AllocationRuleService allocationRuleService) {
        this.allocationRuleService = allocationRuleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetClassAllocationRule> getRuleById(@PathVariable Long id) {
        return allocationRuleService.getRuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<AssetClassAllocationRule>> getRulesByInvestor(@PathVariable Long investorId) {
        return ResponseEntity.ok(allocationRuleService.getRulesByInvestor(investorId));
    }

    @PostMapping
    public ResponseEntity<AssetClassAllocationRule> createRule(
            @RequestBody AssetClassAllocationRule rule) {
        return ResponseEntity.ok(allocationRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetClassAllocationRule> updateRule(
            @PathVariable Long id,
            @RequestBody AssetClassAllocationRule rule) {
        return ResponseEntity.ok(allocationRuleService.updateRule(id, rule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        allocationRuleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
