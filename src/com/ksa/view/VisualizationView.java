package com.ksa.view;

import com.ksa.controller.VisualizationController;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class VisualizationView extends TabPane {

	private final VisualizationController controller;

	public VisualizationView(final VisualizationController controller) {
		this.controller = controller;
	}
}
