package com.example.demo.repository;

import com.example.demo.entity.InvestorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {

    Optional<InvestorProfile> findByEmailId(String investorId);
}
