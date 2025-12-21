package com.example.demo.service;

import com.example.demo.entity.InvestorProfile;
import java.util.List;

public interface InvestorProfileService {

    InvestorProfile createProfile(InvestorProfile profile);

    InvestorProfile getProfileById(Long id);

    InvestorProfile getProfileByInvestorId(String investorId);

    List<InvestorProfile> getAllProfiles();

    InvestorProfile updateProfile(Long id, InvestorProfile profile);

    void deleteProfile(Long id);
}
