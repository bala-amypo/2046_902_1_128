package com.example.demo.util;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for portfolio allocation calculations and JSON operations
 */
public class AllocationUtil {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * Calculate total portfolio value from holdings
     */
    public static double calculateTotalValue(List<HoldingRecord> holdings) {
        return holdings.stream()
                .mapToDouble(HoldingRecord::getCurrentValue)
                .sum();
    }
    
    /**
     * Calculate allocation percentages by asset class
     */
    public static Map<AssetClassType, Double> calculateAllocationPercentages(List<HoldingRecord> holdings) {
        double totalValue = calculateTotalValue(holdings);
        Map<AssetClassType, Double> allocations = new HashMap<>();
        
        if (totalValue == 0) {
            return allocations;
        }
        
        // Group holdings by asset class and sum values
        Map<AssetClassType, Double> assetValues = new HashMap<>();
        for (HoldingRecord holding : holdings) {
            assetValues.merge(holding.getAssetClass(), holding.getCurrentValue(), Double::sum);
        }
        
        // Calculate percentages
        for (Map.Entry<AssetClassType, Double> entry : assetValues.entrySet()) {
            double percentage = (entry.getValue() / totalValue) * 100.0;
            allocations.put(entry.getKey(), Math.round(percentage * 100.0) / 100.0); // Round to 2 decimal places
        }
        
        return allocations;
    }
    
    /**
     * Convert allocation map to JSON string
     */
    public static String allocationToJson(Map<AssetClassType, Double> allocations) {
        try {
            return objectMapper.writeValueAsString(allocations);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert allocation to JSON", e);
        }
    }
    
    /**
     * Parse JSON string to allocation map
     */
    @SuppressWarnings("unchecked")
    public static Map<AssetClassType, Double> jsonToAllocation(String json) {
        try {
            Map<String, Double> stringMap = objectMapper.readValue(json, Map.class);
            Map<AssetClassType, Double> allocationMap = new HashMap<>();
            
            for (Map.Entry<String, Double> entry : stringMap.entrySet()) {
                AssetClassType assetClass = AssetClassType.valueOf(entry.getKey());
                allocationMap.put(assetClass, entry.getValue());
            }
            
            return allocationMap;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON to allocation", e);
        }
    }
    
    /**
     * Check if current allocation deviates from target by more than threshold
     */
    public static boolean isRebalancingNeeded(double currentPercentage, double targetPercentage, double threshold) {
        return Math.abs(currentPercentage - targetPercentage) > threshold;
    }
    
    /**
     * Calculate deviation percentage
     */
    public static double calculateDeviation(double currentPercentage, double targetPercentage) {
        return Math.abs(currentPercentage - targetPercentage);
    }
    
    /**
     * Validate that percentages sum to approximately 100%
     */
    public static boolean isValidAllocation(Map<AssetClassType, Double> allocations, double tolerance) {
        double sum = allocations.values().stream().mapToDouble(Double::doubleValue).sum();
        return Math.abs(sum - 100.0) <= tolerance;
    }
    
    /**
     * Format percentage for display
     */
    public static String formatPercentage(double percentage) {
        return String.format("%.2f%%", percentage);
    }
    
    /**
     * Format currency value for display
     */
    public static String formatCurrency(double value) {
        return String.format("$%.2f", value);
    }
}