package com.ksa.view;

import com.ksa.controller.SearchController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchView extends VBox {

	private final SearchController controller;

	private final HBox searchPanel = new HBox();
	private final TextArea searchResults = new TextArea();
	private final TextField searchField = new TextField();
	private final Button searchBtn = new Button("Search");

	public TextArea getSearchResults() {
		return searchResults;
	}

	public TextField getSearchField() {
		return searchField;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public SearchView(final SearchController controller) {
		this.controller = controller;

		this.searchField.setOnAction(controller);
		this.searchBtn.setOnAction(controller);

		this.searchPanel.getChildren().addAll(searchField, searchBtn);
		this.getChildren().addAll(searchResults, searchPanel);

		initView();
	}

	private void initView() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}
}
