package com.ksa.model;

import com.ksa.controller.VisualizationController;

public class VisualizationModel {

	private VisualizationController controller;
	private boolean chartVisible = false;
	private boolean initialised = false;

	public VisualizationModel(VisualizationController controller) {
		this.controller = controller;
	}

	public boolean isChartVisible() {
		return chartVisible;
	}

	public void setChartVisible(boolean chartVisible) {
		this.chartVisible = chartVisible;
	}

	public boolean isInitialised() {
		return initialised;
	}

	public void setInitialised(boolean initialised) {
		this.initialised = initialised;
	}
}
