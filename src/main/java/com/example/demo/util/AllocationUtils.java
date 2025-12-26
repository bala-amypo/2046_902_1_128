package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class AllocationUtil {

    public static Map<String, Double> normalizeAllocations(Map<String, Double> input) {
        Map<String, Double> normalized = new HashMap<>();
        double total = input.values().stream().mapToDouble(Double::doubleValue).sum();
        if (total == 0) return input;
        for (Map.Entry<String, Double> entry : input.entrySet()) {
            normalized.put(entry.getKey(), entry.getValue() / total);
        }
        return normalized;
    }

    public static double getTotal(Map<String, Double> input) {
        return input.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public static Map<String, Double> mergeAllocations(Map<String, Double> a, Map<String, Double> b) {
        Map<String, Double> merged = new HashMap<>(a);
        for (Map.Entry<String, Double> entry : b.entrySet()) {
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0.0) + entry.getValue());
        }
        return merged;
    }
}
