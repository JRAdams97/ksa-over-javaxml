package com.ksa.view;

import com.ksa.controller.VisualizationController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Set;

public class VisualizationView extends VBox {

	private static final String LBL_SELECTION = "Using the radio buttons to the left, choose the "
			+ "number of top correlated keywords you want to chart. Correlated keywords are "
			+ "keywords that are related to the movies found in the search results. Once a "
			+ "selection has been made, you can chart the keywords in either a bar or pie chart.";

	private final VisualizationController controller;

	private final HBox visualizationPanel = new HBox();
	private final Label selectionPanelLbl = new Label(LBL_SELECTION);
	private final VBox selectionPanel = new VBox();
	private final VBox chartPanel = new VBox();
	private final RadioButton top3Keywords = new RadioButton("Top-3 Keywords");
	private final RadioButton top5Keywords = new RadioButton("Top-5 Keywords");
	private final RadioButton top8Keywords = new RadioButton("Top-8 Keywords");
	private final RadioButton top10Keywords = new RadioButton("Top-10 Keywords");
	private final ToggleGroup topKeywordsGrp = new ToggleGroup();
	private final Button pieChartBtn = new Button("Pie Chart");
	private final Button barChartBtn = new Button("Bar Chart");

	public VisualizationController getController() {
		return controller;
	}

	public Label getSelectionPanelLbl() {
		return selectionPanelLbl;
	}

	public HBox getVisualizationPanel() {
		return visualizationPanel;
	}

	public VBox getSelectionPanel() {
		return selectionPanel;
	}

	public VBox getChartPanel() {
		return chartPanel;
	}

	public RadioButton getTop3Keywords() {
		return top3Keywords;
	}

	public RadioButton getTop5Keywords() {
		return top5Keywords;
	}

	public RadioButton getTop8Keywords() {
		return top8Keywords;
	}

	public RadioButton getTop10Keywords() {
		return top10Keywords;
	}

	public Button getPieChartBtn() {
		return pieChartBtn;
	}

	public Button getBarChartBtn() {
		return barChartBtn;
	}

	public VisualizationView(final VisualizationController controller) {
		this.controller = controller;

		initView();

		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}

	private void initView() {
		top3Keywords.setOnAction(controller);
		top5Keywords.setOnAction(controller);
		top8Keywords.setOnAction(controller);
		pieChartBtn.setOnAction(controller);
		barChartBtn.setOnAction(controller);

		selectionPanelLbl.setWrapText(true);
		selectionPanelLbl.setPadding(new Insets(16, 8, 16, 8));

		top3Keywords.setPadding(new Insets(8, 16, 8, 16));
		top3Keywords.setToggleGroup(topKeywordsGrp);
		top3Keywords.setSelected(true);

		top5Keywords.setPadding(new Insets(8, 16, 8, 16));
		top5Keywords.setToggleGroup(topKeywordsGrp);

		top8Keywords.setPadding(new Insets(8, 16, 8, 16));
		top8Keywords.setToggleGroup(topKeywordsGrp);

		top10Keywords.setPadding(new Insets(8, 16, 8, 16));
		top10Keywords.setToggleGroup(topKeywordsGrp);

		selectionPanel.getChildren().addAll(
				top3Keywords, top5Keywords, top8Keywords, top10Keywords);

		Region padSelRegion = new Region();
		HBox.setHgrow(padSelRegion, Priority.ALWAYS);

		visualizationPanel.setPadding(new Insets(32, 16, 32, 16));

		chartPanel.setSpacing(6);

		chartPanel.getChildren().addAll(pieChartBtn, barChartBtn);
		visualizationPanel.getChildren().addAll(selectionPanel, padSelRegion, chartPanel);

		Region padChartRegion = new Region();
		VBox.setVgrow(padChartRegion, Priority.ALWAYS);

		getChildren().addAll(selectionPanelLbl, visualizationPanel, padChartRegion);
	}

	public void buildPieChart(HashMap<String, Double> data) {
		ObservableList<PieChart.Data> dataList = FXCollections.observableArrayList();
		Set<String> keys = data.keySet();

		while(keys.iterator().hasNext()) {
			String key = keys.iterator().next();

			dataList.add(new PieChart.Data(key, data.get(key)));
		}

		PieChart chart = new PieChart();

		chart.setData(dataList);
		chart.setLegendSide(Side.LEFT);
		chart.setTitle("Keyword Proportions");
		chart.setClockwise(false);

		getChildren().add(chart);
	}

	public void removeChart() {
		getChildren().remove(getChildren().size() - 1);
	}
}
