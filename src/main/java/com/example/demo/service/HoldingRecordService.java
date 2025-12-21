package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import java.util.List;

public interface HoldingRecordService {

    HoldingRecord create(HoldingRecord record);

    HoldingRecord update(Long id, HoldingRecord record);

    HoldingRecord getById(Long id);

    List<HoldingRecord> getByInvestor(Long investorId);

    List<HoldingRecord> getAll();

    void delete(Long id);
}
