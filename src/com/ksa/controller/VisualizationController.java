package com.ksa.controller;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ksa.model.MainModel;
import com.ksa.model.VisualizationModel;
import com.ksa.view.VisualizationView;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class VisualizationController implements EventHandler {

	private final Stage stage;
	private final VisualizationView view = new VisualizationView(this);
	private final VisualizationModel model = new VisualizationModel(this);

	private Hashtable<String, Integer> top3Keywords = new Hashtable<>();

	public Stage getStage() {
		return stage;
	}

	public VisualizationView getView() {
		return view;
	}

	public VisualizationController(Stage primaryStage) {
		this.stage = primaryStage;
	}

	@Override
	public void handle(final Event event) {
		final Object source = event.getSource();
		Hashtable<String, Integer> visualTable = MainModel.getCorrelatedKeywords();
		System.out.println(visualTable);

		if(source.equals(view.getTop3Keywords())) {
			int count = 1;

			for (Map.Entry<String, Integer> entry : visualTable.entrySet()) {
				if (count > 3) {
					break;
				}

				top3Keywords.put(entry.getKey(), entry.getValue());

				count++;
			}
		} else if (source.equals(view.getPieChartBtn())) {
			if (model.isChartVisible()) {
				view.removeChart();
			}

			Hashtable pieChartData = prepareData();
			view.buildPieChart(pieChartData);

			model.setChartVisible(true);
		}
	}
	
	private Hashtable<String, Double> prepareData() {
		Integer totalKeywords = MainModel.getTotalKeywords();
		Hashtable<String, Double> keywordPortionData = new Hashtable<>();
		Hashtable<String, Integer> correlatedKeywords;

		if (top3Keywords != null) {
			correlatedKeywords = top3Keywords;
		} else {
			correlatedKeywords = MainModel.getCorrelatedKeywords();
		}

		Enumeration<String> keys = correlatedKeywords.keys();
		double keywordPortion;

		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			keywordPortion = (double) correlatedKeywords.get(key) / totalKeywords;

			keywordPortionData.put(key, keywordPortion);
		}

		return keywordPortionData;
	}
}
