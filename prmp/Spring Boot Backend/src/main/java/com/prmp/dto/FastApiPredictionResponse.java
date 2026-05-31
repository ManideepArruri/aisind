package com.prmp.dto;

public class FastApiPredictionResponse {

    private Integer delay_probability;

    private String risk_status;

    private String recommendation;

	public Integer getDelay_probability() {
		return delay_probability;
	}

	public void setDelay_probability(Integer delay_probability) {
		this.delay_probability = delay_probability;
	}

	public String getRisk_status() {
		return risk_status;
	}

	public void setRisk_status(String risk_status) {
		this.risk_status = risk_status;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
    
    

}