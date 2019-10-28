package com.ksa.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView extends TabPane {

	static final Integer PREF_TXTAREA_ROWS = 16;

	private final ObservableList<? extends Tab> tabList;

	public MainView(Node sourceView, Node searchView, Node visualizationView) {
		this.tabList = FXCollections.observableArrayList(
				new Tab("Source", sourceView),
				new Tab("Search", searchView),
				new Tab("Visualization", visualizationView));

		getTabs().addAll(tabList);

		initView();
	}

	private void initView() {
		setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		setTabMinWidth(128d);
	}
}
