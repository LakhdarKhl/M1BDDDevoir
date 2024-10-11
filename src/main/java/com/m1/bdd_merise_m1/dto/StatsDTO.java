package com.m1.bdd_merise_m1.dto;

public class StatsDTO {
    private Integer answersCount;
    private Double delayRate;
    private Double packageStateRate;
    private Double deliveryRate;
    
    public StatsDTO() {
    }

    public Integer getAnswersCount() {
        return answersCount;
    }

    public void setAnswersCount(Integer answersCount) {
        this.answersCount = answersCount;
    }

    public Double getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(Double delayRate) {
        this.delayRate = delayRate;
    }

    public Double getPackageStateRate() {
        return packageStateRate;
    }

    public void setPackageStateRate(Double packageStateRate) {
        this.packageStateRate = packageStateRate;
    }

    public Double getDeliveryRate() {
        return deliveryRate;
    }

    public void setDeliveryRate(Double deliveryRate) {
        this.deliveryRate = deliveryRate;
    }
}
