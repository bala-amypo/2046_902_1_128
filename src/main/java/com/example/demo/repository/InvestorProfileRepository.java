package com.example.demo.repository;

import com.example.demo.entity.InvestorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorProfileRepository extends JpaRepository<InvestorProfile, Long> {
}
