package com.ksa.controller;

import com.ksa.view.MainView;
import javafx.stage.Stage;

public class MainController {

	private Stage primaryStage;
	private final MainView primaryView;
	private SourceController sourceController;
	private SearchController searchController;
	private VisualizationController visualizationController;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public MainView getPrimaryView() {
		return primaryView;
	}

	public SourceController getSourceController() {
		return sourceController;
	}

	public SearchController getSearchController() {
		return searchController;
	}

	public VisualizationController getVisualizationController() {
		return visualizationController;
	}

	public MainController(final Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.sourceController = new SourceController(primaryStage);
		this.searchController = new SearchController(primaryStage);
		this.visualizationController = new VisualizationController(primaryStage);
		this.primaryView = new MainView(sourceController.getView(), searchController.getView(),
				visualizationController.getView());
	}
}
