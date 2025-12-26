package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {
    
    private final InvestorProfileService investorProfileService;
    
    public InvestorProfileController(InvestorProfileService investorProfileService) {
        this.investorProfileService = investorProfileService;
    }
    
    @PostMapping
    public ResponseEntity<InvestorProfile> createInvestor(@RequestBody InvestorProfile investor) {
        return ResponseEntity.ok(investorProfileService.createInvestor(investor));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<InvestorProfile> getInvestorById(@PathVariable Long id) {
        return ResponseEntity.ok(investorProfileService.getInvestorById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<InvestorProfile>> getAllInvestors() {
        return ResponseEntity.ok(investorProfileService.getAllInvestors());
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<InvestorProfile> updateInvestorStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(investorProfileService.updateInvestorStatus(id, active));
    }
    
    @GetMapping("/lookup/{investorId}")
    public ResponseEntity<Optional<InvestorProfile>> getByInvestorId(@PathVariable String investorId) {
        return ResponseEntity.ok(investorProfileService.findByInvestorId(investorId));
    }
}