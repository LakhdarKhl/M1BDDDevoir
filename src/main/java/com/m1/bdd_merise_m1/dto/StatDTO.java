package com.m1.bdd_merise_m1.dto;

public class StatDTO {
    private String label;
    private String average;
    
    public StatDTO(String label, Double value) {
        this.label = label;
        this.average = String.format("%.2f", value);
        if (this.average.endsWith(".00")) {
            this.average = this.average.substring(0, this.average.length() - 3);
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
