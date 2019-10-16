package com.ksa.view;

import com.ksa.controller.VisualizationController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VisualizationView extends VBox {

	private final VisualizationController controller;

	private final HBox visualizationPanel = new HBox();
	private final VBox selectionPanel = new VBox();
	private final VBox chartPanel = new VBox();
	private final RadioButton top3Keywords = new RadioButton("Top-3 Keywords");
	private final RadioButton top5Keywords = new RadioButton("Top-5 Keywords");
	private final RadioButton top8Keywords = new RadioButton("Top-8 Keywords");
	private final RadioButton top10Keywords = new RadioButton("Top-10 Keywords");
	private final Button pieChartBtn = new Button("Pie Chart");
	private final Button barChartBtn = new Button("Bar Chart");

	public VisualizationView(final VisualizationController controller) {
		this.controller = controller;

		this.selectionPanel.getChildren().addAll(
				top3Keywords, top5Keywords, top8Keywords, top10Keywords);
		this.chartPanel.getChildren().addAll(pieChartBtn, barChartBtn);
		this.visualizationPanel.getChildren().addAll(selectionPanel, chartPanel);
		this.getChildren().addAll(visualizationPanel);

		initView();
	}

	private void initView() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}
}
