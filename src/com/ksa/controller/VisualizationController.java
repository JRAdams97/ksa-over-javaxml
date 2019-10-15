package com.ksa.controller;

import com.ksa.view.VisualizationView;
import javafx.stage.Stage;

public class VisualizationController {

	private final Stage stage;
	private final VisualizationView view = new VisualizationView(this);

	public Stage getStage() {
		return stage;
	}

	public VisualizationView getView() {
		return view;
	}

	public VisualizationController(Stage primaryStage) {
		this.stage = primaryStage;
	}
}
