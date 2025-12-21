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
    public HoldingRecord create(@RequestBody HoldingRecord record) {
        return service.create(record);
    }

    @GetMapping("/{id}")
    public HoldingRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> getByInvestor(@PathVariable Long investorId) {
        return service.getByInvestor(investorId);
    }

    @GetMapping
    public List<HoldingRecord> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public HoldingRecord update(@PathVariable Long id, @RequestBody HoldingRecord record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
