package com.ksa.view;

import com.ksa.controller.VisualizationController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VisualizationView extends VBox {

	private final VisualizationController controller;

	private final HBox visualizationPanel = new HBox();
	private final VBox selectionPanel = new VBox();
	private final VBox chartPanel = new VBox();
	
	public VisualizationView(final VisualizationController controller) {
		this.controller = controller;
	}
}
