package com.ksa.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView extends TabPane {

	private final ObservableList<? extends Tab> tabList;

	public MainView(Node sourceView, Node searchView, Node visualizationView) {
		this.tabList = FXCollections.observableArrayList(new Tab("Source", sourceView),
				new Tab("Search", searchView), new Tab("Visualization", visualizationView));

		getTabs().addAll(tabList);
	}
}
