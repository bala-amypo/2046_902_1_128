package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordService service;

    public HoldingRecordController(HoldingRecordService service) {
        this.service = service;
    }

    @PostMapping
    public HoldingRecord create(@RequestBody HoldingRecord holding) {
        return service.recordHolding(holding);
    }

    @GetMapping("/{id}")
    public HoldingRecord getById(@PathVariable Long id) {
        return service.getHoldingById(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> getByInvestor(@PathVariable Long investorId) {
        return service.getHoldingsByInvestor(investorId);
    }

    @GetMapping
    public List<HoldingRecord> getAll() {
        return service.getAllHoldings();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteHolding(id);
    }
}
