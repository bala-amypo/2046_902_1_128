package com.example.demo.service.impl;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    private final InvestorProfileRepository repo;

    public InvestorProfileServiceImpl(InvestorProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public InvestorProfile createProfile(InvestorProfile profile) {
        return repo.save(profile);
    }

    @Override
    public InvestorProfile getProfileById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public InvestorProfile getProfileByInvestorId(String investorId) {
        return repo.findByInvestorId(investorId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public List<InvestorProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public InvestorProfile updateProfile(Long id, InvestorProfile profile) {
        InvestorProfile existing = getProfileById(id);

        existing.setEmail(profile.getEmail());
        existing.setFullName(profile.getFullName());
        existing.setActive(profile.isActive());


        return repo.save(existing);
    }

    @Override
    public void deleteProfile(Long id) {
        repo.deleteById(id);
    }
}
