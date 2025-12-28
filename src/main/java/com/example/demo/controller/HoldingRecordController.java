package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordService holdingRecordService;

    public HoldingRecordController(HoldingRecordService holdingRecordService) {
        this.holdingRecordService = holdingRecordService;
    }

    @PostMapping
    public ResponseEntity<HoldingRecord> recordHolding(@RequestBody HoldingRecord holding) {
        return ResponseEntity.ok(holdingRecordService.recordHolding(holding));
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getHoldingsByInvestor(@PathVariable Long investorId) {
        return ResponseEntity.ok(holdingRecordService.getHoldingsByInvestor(investorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoldingRecord> getHoldingById(@PathVariable Long id) {
        return holdingRecordService.getHoldingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HoldingRecord>> getAllHoldings() {
        return ResponseEntity.ok(holdingRecordService.getAllHoldings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long id) {
        holdingRecordService.deleteHolding(id);
        return ResponseEntity.noContent().build();
    }
}
