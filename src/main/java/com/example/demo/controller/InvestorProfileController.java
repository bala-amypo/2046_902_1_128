package com.example.demo.controller;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile create(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAll() {
        return service.getAllInvestors();
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookup(@PathVariable String investorId) {
        return service.findByInvestorId(investorId);
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateInvestorStatus(id, active);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteInvestor(id);
    }
}
