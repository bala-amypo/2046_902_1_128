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
    public InvestorProfile create(@RequestBody InvestorProfile profile) {
        return service.createProfile(profile);
    }

    @GetMapping("/{id}")
    public InvestorProfile getById(@PathVariable Long id) {
        return service.getProfileById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAll() {
        return service.getAllProfiles();
    }

    @GetMapping("/unique/{investorId}")
    public InvestorProfile getByInvestorId(@PathVariable String investorId) {
        return service.getProfileByInvestorId(investorId);
    }

    @PutMapping("/{id}")
    public InvestorProfile update(@PathVariable Long id, @RequestBody InvestorProfile profile) {
        return service.updateProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProfile(id);
    }
}
