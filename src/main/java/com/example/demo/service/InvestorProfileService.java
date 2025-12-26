package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorProfileService {

    private final InvestorProfileRepository repository;

    public InvestorProfileService(InvestorProfileRepository repository) {
        this.repository = repository;
    }

    public List<InvestorProfile> getAllInvestors() {
        return repository.findAll();
    }

    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repository.save(investor);
    }
}
